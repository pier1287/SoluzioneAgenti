package it.carusopi.soluzioneagenti.data.interactor

import io.reactivex.Flowable
import io.realm.Realm
import it.carusopi.soluzioneagenti.data.model.Customer
import it.carusopi.soluzioneagenti.data.model.CustomerPage
import javax.inject.Inject

/**
 * Created by carusopi on 09/02/2018.
 */
class CustomerInteractorRealm @Inject constructor(val realm: Realm) : CustomerInteractor {

    override fun getCustomers(): Flowable<CustomerPage> {

//        val customersRealm = realm.where(Customer::class.java)
//                .findAllAsync().asIterable()
//
//        val customers = LinkedList<Customer>()
//        customers.addAll(customersRealm)
//
//        return Observable.just(CustomerPage(customers , null))

        return realm.where(Customer::class.java)
                .findAllAsync()
                .asFlowable()
                .filter { it.isLoaded }
                .map{ CustomerPage(it, null)}
    }

    override fun getMoreCustomers(): Flowable<CustomerPage> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveCustomer(customer: Customer) {
        realm.beginTransaction()
        realm.copyToRealm(customer)
        realm.commitTransaction()
    }
}