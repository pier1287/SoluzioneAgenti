package it.carusopi.soluzioneagenti.base.di.module

import android.app.Application
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import it.carusopi.soluzioneagenti.data.network.interceptor.HttpErrorInterceptor
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by carusopi on 27/10/2017.
 */
@Module
class OkHttpModule {
    private fun getBaseBuilder(cache: Cache): OkHttpClient.Builder {
        val lBuilder = OkHttpClient.Builder()
                .cache(cache)
                .retryOnConnectionFailure(true)
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
        return lBuilder
    }

    private class CachingControlInterceptor : Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response {

            val requestBuilder = chain.request().newBuilder()
            val cacheControl = CacheControl.Builder()
                    .maxStale(1, TimeUnit.MINUTES)
                    .maxAge(1, TimeUnit.MINUTES)
                    .build()

            requestBuilder.cacheControl(cacheControl)
            requestBuilder.header("Content-Type", "application/json")
            val request = requestBuilder.build()

            val originalResponse = chain.proceed(request)
            return originalResponse.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "public, only-if-cached, max-stale=604800")
                    .build()
        }
    }

    @Provides
    @Singleton
    fun providesOkHttpCache(pApplication: Application): Cache {
        return Cache(pApplication.cacheDir, 10 * 1024 * 1024)
    }

    @Provides
    @Singleton
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    fun providesErrorInterceptor(gson: Gson): HttpErrorInterceptor = HttpErrorInterceptor(gson)

    @Provides
    @Singleton
    fun providesOkHttp(cache: Cache, loggingInterceptor: HttpLoggingInterceptor, httpErrorInterceptor: HttpErrorInterceptor) =
            getBaseBuilder(cache)
                    .addNetworkInterceptor(CachingControlInterceptor())
                    .addInterceptor(httpErrorInterceptor)
                    .addInterceptor(loggingInterceptor)
                    .build()
}