package it.carusopi.soluzioneagenti.base.di.module

import android.util.Log
import dagger.Module
import dagger.Provides
import io.realm.*
import javax.inject.Singleton
import io.realm.SyncUser.*


/**
 * Created by carusopi on 09/02/2018.
 */
@Module
class RealmModule {

    @Provides
    @Singleton
    fun provideRealm(): Realm {
        return Realm.getDefaultInstance()
    }

}