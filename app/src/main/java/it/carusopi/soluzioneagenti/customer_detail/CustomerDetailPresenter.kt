package it.carusopi.soluzioneagenti.customer_detail

import it.carusopi.soluzioneagenti.data.interactor.customer.CustomerInteractor
import javax.inject.Inject

/**
 * Created by carusopi on 24/11/2017.
 */
class CustomerDetailPresenter @Inject constructor(private var customerInteractor: CustomerInteractor):
        CustomerDetailContract.Presenter() {

}