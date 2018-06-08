package it.carusopi.soluzioneagenti.data.model

import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by carusopi on 23/11/2017.
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class Customer(
        @SerializedName("id") val id: Long,
        @SerializedName("business_name") val businessName: String? = null,
        @SerializedName("postal_code") val cap: Int? = null,
        @SerializedName("city") val city: String? = null,
        @SerializedName("email") val email: String? = null,
        @SerializedName("phone") val phone: String? = null,
        @SerializedName("cell") val mobile: String? = null,
        @SerializedName("address") val address: String? = null) : Parcelable