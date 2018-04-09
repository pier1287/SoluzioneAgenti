package it.carusopi.soluzioneagenti.base.di.module

import android.app.Application
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by carusopi on 27/10/2017.
 */
@Module(includes = [(ViewModelModule::class)])
class AppModule {

    @Provides
    @Singleton
    fun providesGson() = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create()

//    @Provides
//    @Singleton
//    fun providesApplication() = application

    @Provides
    @Singleton
    fun providesResources(application: Application) = application.resources

}