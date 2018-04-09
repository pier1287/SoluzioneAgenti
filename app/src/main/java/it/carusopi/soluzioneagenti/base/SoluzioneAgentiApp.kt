package it.carusopi.soluzioneagenti.base

import android.app.Activity
import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import it.carusopi.soluzioneagenti.base.di.AppInjector
import it.carusopi.soluzioneagenti.base.di.component.DaggerAppComponent
import javax.inject.Inject

/**
 * Created by carusopi on 27/10/2017.
 */
class SoluzioneAgentiApp : Application(), HasActivityInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        AppInjector(this)

        Fresco.initialize(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = androidInjector
}