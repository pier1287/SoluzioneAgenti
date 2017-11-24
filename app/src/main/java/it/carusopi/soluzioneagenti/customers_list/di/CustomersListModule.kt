package it.carusopi.soluzioneagenti.customers_list.di

import dagger.Module
import dagger.Provides
import it.carusopi.soluzioneagenti.base.di.ActivityScope
import it.carusopi.soluzioneagenti.customers_list.CustomersListContract
import it.carusopi.soluzioneagenti.customers_list.CustomersListPresenter
import it.carusopi.soluzioneagenti.data.interactor.CustomerInteractor

/**
 * Created by carusopi on 23/11/2017.
 */
@Module
class CustomersListModule {
    @Provides
    @ActivityScope
    internal fun providesCustomersListPresenter(interactor: CustomerInteractor): CustomersListContract.Presenter {
        return CustomersListPresenter(interactor)
    }
}