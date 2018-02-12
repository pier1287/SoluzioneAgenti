package it.carusopi.soluzioneagenti.data.interactor

import io.reactivex.Flowable
import io.reactivex.Observable
import it.carusopi.soluzioneagenti.data.model.Customer
import it.carusopi.soluzioneagenti.data.model.CustomerPage

/**
 * Created by carusopi on 23/11/2017.
 */
interface CustomerInteractor {
    fun getCustomers(): Flowable<CustomerPage>
    fun getMoreCustomers(): Flowable<CustomerPage>
    fun saveCustomer(customer: Customer)
}