package it.carusopi.soluzioneagenti.base.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import it.carusopi.soluzioneagenti.customer_detail.CustomerDetailActivity
import it.carusopi.soluzioneagenti.customers_list.CustomersListActivity

/**
 * Created by carusopi on 28/03/2018.
 */
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeCustomersListActivity() : CustomersListActivity

    @ContributesAndroidInjector
    abstract fun contributeCustomersDetailActivity() : CustomerDetailActivity
}