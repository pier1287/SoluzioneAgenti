package it.carusopi.soluzioneagenti.customer_detail.di

import dagger.Module
import dagger.Provides
import it.carusopi.soluzioneagenti.base.di.ActivityScope
import it.carusopi.soluzioneagenti.customer_detail.CustomerDetailContract
import it.carusopi.soluzioneagenti.customer_detail.CustomerDetailPresenter
import it.carusopi.soluzioneagenti.data.interactor.CustomerInteractor

/**
 * Created by carusopi on 24/11/2017.
 */
@Module
class CustomerDetailModule {
    @Provides
    @ActivityScope
    internal fun providesCustomerDetailPresenter(interactor: CustomerInteractor)
            : CustomerDetailContract.Presenter = CustomerDetailPresenter(interactor)
}