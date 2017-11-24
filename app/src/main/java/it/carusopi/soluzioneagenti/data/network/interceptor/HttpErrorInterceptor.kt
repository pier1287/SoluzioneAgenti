package it.carusopi.soluzioneagenti.data.network.interceptor

import com.google.gson.Gson
import it.carusopi.soluzioneagenti.data.model.ErrorBody
import it.carusopi.soluzioneagenti.data.model.exception.HttpErrorException
import it.carusopi.soluzioneagenti.data.model.exception.HttpForbiddenException
import it.carusopi.soluzioneagenti.data.model.exception.HttpNotFoundException
import okhttp3.Interceptor
import okhttp3.Response
import okio.Buffer
import java.io.EOFException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by carusopi on 04/11/2017.
 */
@Singleton
class HttpErrorInterceptor @Inject constructor(val gson: Gson) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        if (response.code() != 200) {
            val bodyString = responseBody2String(response)
            val errorBody = gson.fromJson(bodyString, ErrorBody::class.java)

            when (response.code()) {
                404 -> throw HttpNotFoundException(errorBody.messageDetail)
                403 -> throw HttpForbiddenException(errorBody.messageDetail)
                else -> throw HttpErrorException(errorBody.messageDetail, response.code())
            }
        }
        return response
    }

    private fun responseBody2String(response: Response): String? {

        val responseBody = response.body()

        return responseBody?.let {

            val source = responseBody.source()
            source.request(Long.MAX_VALUE)
            val buffer = source.buffer()

            if (responseBody.contentLength() == 0L || !isPlaintext(buffer)) {
                null
            } else {
                val contentType = responseBody.contentType()

                val charset = contentType?.charset(Charsets.UTF_8) ?: Charsets.UTF_8

                buffer.clone().readString(charset)
            }
        }
    }

    private fun isPlaintext(buffer: Buffer): Boolean {
        try {
            val prefix = Buffer()
            val byteCount = if (buffer.size() < 64) buffer.size() else 64
            buffer.copyTo(prefix, 0, byteCount)

            for (i in 0..16) {
                if (prefix.exhausted()) {
                    break
                }
                val codePoint = prefix.readUtf8CodePoint();
                if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
                    return false
                }
            }
            return true
        } catch (e: EOFException) {
            return false
        }
    }
}



