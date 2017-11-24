package it.carusopi.soluzioneagenti.customers_list.di

import dagger.Component
import it.carusopi.soluzioneagenti.base.di.ActivityScope
import it.carusopi.soluzioneagenti.base.di.component.AppComponent
import it.carusopi.soluzioneagenti.customers_list.CustomersListActivity

/**
 * Created by carusopi on 23/11/2017.
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(CustomersListModule::class))
interface CustomersListComponent {
    fun inject (customersListActivity: CustomersListActivity)
}