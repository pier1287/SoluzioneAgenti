package it.carusopi.soluzioneagenti.dashboard.di

import dagger.Module
import dagger.Provides
import it.carusopi.soluzioneagenti.base.di.ActivityScope
import it.carusopi.soluzioneagenti.dashboard.DashboardContract
import it.carusopi.soluzioneagenti.dashboard.DashboardPresenter
import it.carusopi.soluzioneagenti.data.interactor.CustomerInteractor

/**
 * Created by carusopi on 23/11/2017.
 */
@Module
class DashboardModule {
    @Provides
    @ActivityScope
    internal fun providesDashboardPresenter(interactor: CustomerInteractor): DashboardContract.Presenter {
        return DashboardPresenter(interactor)
    }
}