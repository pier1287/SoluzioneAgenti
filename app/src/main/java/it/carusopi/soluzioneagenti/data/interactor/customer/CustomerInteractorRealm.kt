package it.carusopi.soluzioneagenti.data.interactor.customer

import io.reactivex.Flowable
import io.realm.Realm
import it.carusopi.soluzioneagenti.data.interactor.auth.AuthInteractor
import it.carusopi.soluzioneagenti.data.model.Customer
import it.carusopi.soluzioneagenti.data.model.CustomerPage
import javax.inject.Inject

/**
 * Created by carusopi on 09/02/2018.
 */
class CustomerInteractorRealm @Inject constructor(val authInteractor: AuthInteractor) : CustomerInteractor {

    lateinit var realm: Realm
    override fun getCustomers(): Flowable<CustomerPage> {
        realm = Realm.getInstance(authInteractor.realmSyncConfig)
        return realm.where(Customer::class.java)
                .findAllAsync()
                .asFlowable()
                .filter { it.isLoaded }
                .map{ CustomerPage(it, null) }
    }

    override fun getMoreCustomers(): Flowable<CustomerPage> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveCustomer(customer: Customer) {
        val realm = Realm.getInstance(authInteractor.realmSyncConfig)
        realm.executeTransaction({
            it.insertOrUpdate(customer)
        })
    }
}