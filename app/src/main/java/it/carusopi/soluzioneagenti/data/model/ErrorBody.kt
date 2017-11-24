package it.carusopi.soluzioneagenti.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by carusopi on 04/11/2017.
 */
class ErrorBody(
        @SerializedName("detail") val messageDetail: String? = null)
