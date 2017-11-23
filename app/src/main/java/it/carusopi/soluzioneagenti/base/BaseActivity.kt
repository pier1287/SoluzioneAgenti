package it.carusopi.soluzioneagenti.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import it.carusopi.soluzioneagenti.base.di.component.AppComponent
import it.carusopi.soluzioneagenti.base.mvp.BaseView

/**
 * Created by carusopi on 27/10/2017.
 */
abstract class BaseActivity : AppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onActivityInject()
    }

    protected abstract fun onActivityInject()

    fun getAppcomponent(): AppComponent = SoluzioneAgentiApp.appComponent
}