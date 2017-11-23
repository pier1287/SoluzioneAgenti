package it.carusopi.soluzioneagenti.base.di.module

import dagger.Module
import dagger.Provides
import it.carusopi.soluzioneagenti.data.network.SoluzioneAgentiApiClient
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by carusopi on 27/10/2017.
 */
@Module
class ApiModule {
    @Provides
    @Singleton
    fun providesEndpoints(retrofit: Retrofit): SoluzioneAgentiApiClient = retrofit.create(SoluzioneAgentiApiClient::class.java)
}