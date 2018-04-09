package it.carusopi.soluzioneagenti.base.di.component

import android.app.Application
import com.google.gson.Gson
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import it.carusopi.soluzioneagenti.base.SoluzioneAgentiApp
import it.carusopi.soluzioneagenti.base.di.module.*
import it.carusopi.soluzioneagenti.data.interactor.CustomerInteractor
import it.carusopi.soluzioneagenti.data.network.SoluzioneAgentiApiClient
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ActivityModule::class, AndroidSupportInjectionModule::class,
    OkHttpModule::class, RetrofitModule::class, ApiModule::class, InteractorModule::class
])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    abstract fun inject(soluzioneAgentiApp: SoluzioneAgentiApp)
}