package it.carusopi.soluzioneagenti.dashboard.di

import dagger.Component
import it.carusopi.soluzioneagenti.base.di.ActivityScope
import it.carusopi.soluzioneagenti.base.di.component.AppComponent
import it.carusopi.soluzioneagenti.dashboard.DashboardActivity

/**
 * Created by carusopi on 23/11/2017.
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(DashboardModule::class))
interface DashboardComponent {
    fun inject (dashboardActivity: DashboardActivity)
}