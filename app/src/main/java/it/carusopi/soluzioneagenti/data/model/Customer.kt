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
        @SerializedName("business_name") val businessName: String? = null,
        @SerializedName("cap") val cap: Int? = null,
        @SerializedName("city") val city: String? = null,
        @SerializedName("email") val email: String? = null,
        @SerializedName("telephone") val telephone: String? = null,
        @SerializedName("mobile") val mobile: String? = null,
        @SerializedName("address") val address: String? = null,
        @SerializedName("avatar_url") val avatarUrl: String? = null ) : Parcelable