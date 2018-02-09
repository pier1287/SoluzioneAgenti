package it.carusopi.soluzioneagenti.customer_modify.di

import dagger.Component
import it.carusopi.soluzioneagenti.base.di.ActivityScope
import it.carusopi.soluzioneagenti.base.di.component.AppComponent
import it.carusopi.soluzioneagenti.customer_modify.CustomerModifyActivity
import it.carusopi.soluzioneagenti.customers_list.CustomersListActivity

/**
 * Created by carusopi on 23/11/2017.
 */
@ActivityScope
@Component(dependencies = [(AppComponent::class)], modules = [(CustomerModifyModule::class)])
interface CustomerModifyComponent {
    fun inject (customerModifyActivity: CustomerModifyActivity)
}