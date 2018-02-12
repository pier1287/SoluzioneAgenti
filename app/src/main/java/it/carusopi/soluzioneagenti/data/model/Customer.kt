package it.carusopi.soluzioneagenti.data.model

import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by carusopi on 23/11/2017.
 */
@SuppressLint("ParcelCreator")
@Parcelize
open class Customer(
        @PrimaryKey var id: Long? = null,
        @SerializedName("business_name") var businessName: String? = null,
        @SerializedName("cap") var cap: Int? = null,
        @SerializedName("city") var city: String? = null,
        @SerializedName("email") var email: String? = null,
        @SerializedName("telephone") var telephone: String? = null,
        @SerializedName("mobile") var mobile: String? = null,
        @SerializedName("address") var address: String? = null,
        @SerializedName("avatar_url") var avatarUrl: String? = null ) : RealmObject(), Parcelable