package it.carusopi.soluzioneagenti.customers_list.di

import dagger.Module
import dagger.Provides
import it.carusopi.soluzioneagenti.base.di.ActivityScope
import it.carusopi.soluzioneagenti.customers_list.CustomersListContract
import it.carusopi.soluzioneagenti.customers_list.CustomersListPresenter
import it.carusopi.soluzioneagenti.data.interactor.auth.AuthInteractor
import it.carusopi.soluzioneagenti.data.interactor.customer.CustomerInteractor

/**
 * Created by carusopi on 23/11/2017.
 */
@Module
class CustomersListModule {
    @Provides
    @ActivityScope
    internal fun providesCustomersListPresenter(authInteractor: AuthInteractor, customerInteractor: CustomerInteractor): CustomersListContract.Presenter {
        return CustomersListPresenter(authInteractor, customerInteractor)
    }
}