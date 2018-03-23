package it.carusopi.soluzioneagenti.base.di.module

import dagger.Module
import dagger.Provides
import it.carusopi.soluzioneagenti.data.interactor.auth.AuthInteractor
import it.carusopi.soluzioneagenti.data.interactor.auth.AuthInteractorRealm
import it.carusopi.soluzioneagenti.data.interactor.customer.CustomerInteractor
import it.carusopi.soluzioneagenti.data.interactor.customer.CustomerInteractorImpl
import it.carusopi.soluzioneagenti.data.interactor.customer.CustomerInteractorRealm
import javax.inject.Singleton

/**
 * Created by carusopi on 30/10/2017.
 */
@Module
class InteractorModule {
    @Provides
    @Singleton
    fun providesCustomerInteractor(customerInteractor: CustomerInteractorImpl): CustomerInteractor = customerInteractor

    @Provides
    @Singleton
    fun providesAuthInteractor(authInteractor: AuthInteractorRealm): AuthInteractor = authInteractor
}