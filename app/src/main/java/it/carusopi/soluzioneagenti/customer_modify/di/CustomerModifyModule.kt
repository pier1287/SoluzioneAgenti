package it.carusopi.soluzioneagenti.customer_modify.di

import dagger.Module
import dagger.Provides
import it.carusopi.soluzioneagenti.base.di.ActivityScope
import it.carusopi.soluzioneagenti.customer_modify.CustomerModifyContract
import it.carusopi.soluzioneagenti.customer_modify.CustomerModifyPresenter

/**
 * Created by carusopi on 08/02/2018.
 */
@Module
class CustomerModifyModule {
    @Provides
    @ActivityScope
    internal fun providesCustomerModifyPresenter(): CustomerModifyContract.Presenter {
        return CustomerModifyPresenter()
    }
}