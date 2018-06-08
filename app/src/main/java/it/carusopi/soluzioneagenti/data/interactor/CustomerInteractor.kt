package it.carusopi.soluzioneagenti.data.interactor

import io.reactivex.Observable
import it.carusopi.soluzioneagenti.data.model.Customer
import it.carusopi.soluzioneagenti.data.model.CustomerPage

/**
 * Created by carusopi on 23/11/2017.
 */
interface CustomerInteractor {
    fun getCustomers(): Observable<CustomerPage>
    fun getMoreCustomers(): Observable<CustomerPage>
    fun getCustomerDetails(id: Long): Observable<Customer>
}