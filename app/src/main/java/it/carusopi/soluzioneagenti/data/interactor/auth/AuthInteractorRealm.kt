package it.carusopi.soluzioneagenti.data.interactor.auth

import io.reactivex.BackpressureStrategy.LATEST
import io.reactivex.Flowable
import io.realm.*
import javax.inject.Inject

/**
 * Created by carusopi on 12/02/2018.
 */
class AuthInteractorRealm @Inject constructor(var realm: Realm) : AuthInteractor {

    override lateinit var realmSyncConfig : SyncConfiguration

    override fun login(username: String, pwd: String): Flowable<String> {
        return Flowable.create<String>({ emitter ->
            val authURL = "http://10.0.2.2:9080/auth"
            val credentials = SyncCredentials.usernamePassword(
                    "realm-admin", "", false)

            SyncUser.loginAsync(credentials, authURL, object : SyncUser.Callback<SyncUser> {
                override fun onSuccess(result: SyncUser?) {
                    val realmUrl = ("realm://10.0.2.2:9080/~/agentsSolution")

                    result?.let {
                        realmSyncConfig = SyncConfiguration.Builder(result, realmUrl)
                                .build()
                    }

                    emitter.onNext("")
                    emitter.onComplete()
                }

                override fun onError(error: ObjectServerError?) {
                    error?.let { emitter.onError(error) } ?: emitter.onError(RuntimeException(""))
                }
            })
        }, LATEST)


    }
}