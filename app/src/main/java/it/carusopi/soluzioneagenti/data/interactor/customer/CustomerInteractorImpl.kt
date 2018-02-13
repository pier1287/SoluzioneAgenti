package it.carusopi.soluzioneagenti.data.interactor.customer

import io.reactivex.Flowable
import it.carusopi.soluzioneagenti.data.model.Customer
import it.carusopi.soluzioneagenti.data.model.CustomerPage
import it.carusopi.soluzioneagenti.data.network.SoluzioneAgentiApiClient
import javax.inject.Inject

/**
 * Created by carusopi on 23/11/2017.
 */

class CustomerInteractorImpl @Inject constructor(private var soluzioneAgentiApiClient: SoluzioneAgentiApiClient) : CustomerInteractor {

    private var nextPage: String? = null

    override fun getCustomers(): Flowable<CustomerPage> {
        return soluzioneAgentiApiClient.getCustomers().map {
            nextPage = it.nextPage
            it
        }
    }

    override fun getMoreCustomers(): Flowable<CustomerPage> {
        return nextPage?.let { next ->
            soluzioneAgentiApiClient.getCustomers(next).map {
                nextPage = it.nextPage
                it
            }
        } ?: Flowable.just(CustomerPage(emptyList(), null))
    }

    override fun saveCustomer(customer: Customer) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}