package it.carusopi.soluzioneagenti.base.di.module

import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Singleton




/**
 * Created by carusopi on 09/02/2018.
 */
@Module
class RealmModule {

    @Provides
    @Singleton
    fun provideRealmConfiguration(): RealmConfiguration {
        var builder = RealmConfiguration.Builder()
        return builder.build()
    }

    @Provides
    fun provideRealm(realmConfiguration: RealmConfiguration): Realm {
        return Realm.getInstance(realmConfiguration)
    }

}