package it.carusopi.soluzioneagenti.base.di.component

import android.app.Application
import com.google.gson.Gson
import dagger.Component
import io.realm.Realm
import it.carusopi.soluzioneagenti.base.di.module.*
import it.carusopi.soluzioneagenti.data.interactor.CustomerInteractor
import it.carusopi.soluzioneagenti.data.network.SoluzioneAgentiApiClient
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Component(modules = [(AppModule::class), (RealmModule::class), (OkHttpModule::class), (RetrofitModule::class), (ApiModule::class), (InteractorModule::class)])
@Singleton
interface AppComponent {
    fun application(): Application
    fun realm(): Realm
    fun gson(): Gson
    fun cache(): Cache
    fun client(): OkHttpClient
    fun loggingInterceptor(): HttpLoggingInterceptor
    fun retrofit(): Retrofit
    fun apiClient(): SoluzioneAgentiApiClient
    fun interactorCustomer(): CustomerInteractor
}