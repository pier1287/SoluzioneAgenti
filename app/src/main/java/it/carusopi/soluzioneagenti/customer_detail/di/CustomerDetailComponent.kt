package it.carusopi.soluzioneagenti.customer_detail.di

import dagger.Component
import it.carusopi.soluzioneagenti.base.di.ActivityScope
import it.carusopi.soluzioneagenti.base.di.component.AppComponent

/**
 * Created by carusopi on 24/11/2017.
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(CustomerDetailModule::class))
interface CustomerDetailComponent {}