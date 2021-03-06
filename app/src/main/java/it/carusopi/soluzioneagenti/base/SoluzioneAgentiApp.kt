package it.carusopi.soluzioneagenti.base

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import it.carusopi.soluzioneagenti.base.di.component.AppComponent
import it.carusopi.soluzioneagenti.base.di.component.DaggerAppComponent
import it.carusopi.soluzioneagenti.base.di.module.AppModule

/**
 * Created by carusopi on 27/10/2017.
 */
class SoluzioneAgentiApp : Application() {

    companion object {
        @JvmStatic lateinit var appComponent: AppComponent
    }

    fun getAppcomponent(): AppComponent = SoluzioneAgentiApp.appComponent

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}