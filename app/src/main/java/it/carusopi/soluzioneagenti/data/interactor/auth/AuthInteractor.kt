package it.carusopi.soluzioneagenti.data.interactor.auth

import io.reactivex.Flowable
import io.realm.SyncConfiguration

/**
 * Created by carusopi on 12/02/2018.
 */
interface AuthInteractor {
    fun login(username: String, pwd: String): Flowable<String>
    var realmSyncConfig : SyncConfiguration
}