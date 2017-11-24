package it.carusopi.soluzioneagenti.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by carusopi on 23/11/2017.
 */
data class CustomerPage(
        @SerializedName("results") val customersList: List<Customer>,
        @SerializedName("next") val nextPage: String?){

    fun hasNextPage(): Boolean = nextPage != null
    fun isEmpty(): Boolean = customersList.isEmpty()
}