package it.carusopi.soluzioneagenti.base.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import dagger.android.AndroidInjection
import it.carusopi.soluzioneagenti.base.SoluzioneAgentiApp
import it.carusopi.soluzioneagenti.base.di.component.DaggerAppComponent

/**
 * Created by carusopi on 28/03/2018.
 */

class AppInjector(soluzioneAgentiApp: SoluzioneAgentiApp) {

    init {
        DaggerAppComponent.builder()
                .application(soluzioneAgentiApp)
                .build().inject(soluzioneAgentiApp)

        soluzioneAgentiApp.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity?) {}
            override fun onActivityResumed(activity: Activity?) {}
            override fun onActivityStarted(activity: Activity?) {}
            override fun onActivityDestroyed(activity: Activity?) {}
            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {}
            override fun onActivityStopped(activity: Activity?) {}
            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                AndroidInjection.inject(activity)
            }
        })
    }

}