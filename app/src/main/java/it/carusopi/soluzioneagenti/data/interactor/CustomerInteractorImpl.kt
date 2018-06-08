package it.carusopi.soluzioneagenti.data.interactor

import io.reactivex.Observable
import it.carusopi.soluzioneagenti.data.model.Customer
import it.carusopi.soluzioneagenti.data.model.CustomerPage
import it.carusopi.soluzioneagenti.data.network.SoluzioneAgentiApiClient
import javax.inject.Inject

/**
 * Created by carusopi on 23/11/2017.
 */

class CustomerInteractorImpl @Inject constructor(private var soluzioneAgentiApiClient: SoluzioneAgentiApiClient) : CustomerInteractor {

    private var nextPage: String? = null

    override fun getCustomers(): Observable<CustomerPage> {
        return soluzioneAgentiApiClient.getCustomers().map {
            nextPage = it.nextPage
            it
        }
    }

    override fun getMoreCustomers(): Observable<CustomerPage> {
        return nextPage?.let { next ->
            soluzioneAgentiApiClient.getCustomers(next).map {
                nextPage = it.nextPage
                it
            }
        } ?: Observable.just(CustomerPage(emptyList(), null))
    }

    override fun getCustomerDetails(id: Long): Observable<Customer> {
        return soluzioneAgentiApiClient.getCustomerDetail(id)
    }
}