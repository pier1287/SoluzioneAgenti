package it.carusopi.soluzioneagenti.data.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by carusopi on 23/11/2017.
 */
open class Supplier(
        @PrimaryKey var id: Long? = null,
        var businessName: String? = null,
        var cap: Int? = null,
        var city: String? = null,
        var email: String? = null,
        var telephone: String? = null,
        var mobile: String? = null,
        var address: String? = null,
        var avatarUrl: String? = null,
        var customers: RealmList<Customer>? = null) : RealmObject()