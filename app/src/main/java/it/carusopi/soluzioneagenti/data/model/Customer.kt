package it.carusopi.soluzioneagenti.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by carusopi on 23/11/2017.
 */
data class Customer(
        @SerializedName("business_name") val login: String? = null,
        @SerializedName("cap") val cap: Int? = null,
        @SerializedName("city") val city: String? = null,
        @SerializedName("email") val email: String? = null,
        @SerializedName("telephone") val telephone: String? = null,
        @SerializedName("mobile") val mobile: String? = null,
        @SerializedName("address") val address: String? = null)