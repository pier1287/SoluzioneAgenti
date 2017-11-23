package it.carusopi.soluzioneagenti.dashboard

import it.carusopi.soluzioneagenti.data.interactor.CustomerInteractor
import javax.inject.Inject

/**
 * Created by carusopi on 23/11/2017.
 */
class DashboardPresenter @Inject constructor(private var customerInteractor: CustomerInteractor): DashboardContract.Presenter() {

}