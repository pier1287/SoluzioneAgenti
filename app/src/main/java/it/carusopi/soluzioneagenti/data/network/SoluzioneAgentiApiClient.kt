package it.carusopi.soluzioneagenti.data.network

import io.reactivex.Observable
import it.carusopi.soluzioneagenti.data.model.CustomerPage
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Created by carusopi on 23/11/2017.
 */
interface SoluzioneAgentiApiClient {
    @GET("/customers")
    fun getCustomers(): Observable<CustomerPage>

    @GET()
    fun getCustomers(@Url url: String): Observable<CustomerPage>
}