package it.carusopi.soluzioneagenti.base.di.module

import dagger.Module
import dagger.Provides
import it.carusopi.soluzioneagenti.data.interactor.CustomerInteractor
import it.carusopi.soluzioneagenti.data.interactor.CustomerInteractorImpl
import javax.inject.Singleton

/**
 * Created by carusopi on 30/10/2017.
 */
@Module
class InteractorModule {
    @Provides
    fun providesCustomerInteractor(customerInteractor: CustomerInteractorImpl): CustomerInteractor = customerInteractor
}