package it.carusopi.soluzioneagenti.customers_list

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import it.carusopi.soluzioneagenti.commons.rx.dispose
import it.carusopi.soluzioneagenti.data.interactor.auth.AuthInteractor
import it.carusopi.soluzioneagenti.data.interactor.customer.CustomerInteractor
import it.carusopi.soluzioneagenti.data.model.Customer
import it.carusopi.soluzioneagenti.data.model.CustomerPage
import it.carusopi.soluzioneagenti.data.model.exception.HttpNotFoundException
import java.util.*
import javax.inject.Inject

/**
 * Created by carusopi on 23/11/2017.
 */
class CustomersListPresenter @Inject constructor(private var authInteractor: AuthInteractor, private var customerInteractor: CustomerInteractor)
    : CustomersListContract.Presenter() {

    private val LOGTAG = "[CustomersListP]"

    private val disposables = mutableListOf<Disposable>()

    override fun loadCustomers() {
        view?.showListLoading()
        authInteractor.login("", "").flatMap { customerInteractor.getCustomers() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetCustomersListSuccess, this::onGetCustomersListError)

    }

    private fun onGetCustomersListError(ex: Throwable?) {
        Log.d(LOGTAG, "onGetCustomersListError", ex)
        when (ex) {
            is HttpNotFoundException -> {
//                view?.showListError(R.string.err_not_found_list)
            }
            else -> {
//                view?.showListError(R.string.err_generic)
            }
        }
        view?.hideListLoading()
    }

    private fun onGetCustomersListSuccess(customerPage: CustomerPage) {
        if (customerPage.isEmpty()) {
            view?.showListEmpty()
        } else {
            view?.showCustomers(customerPage)
        }
        view?.hideListLoading()
    }

    override fun loadMoreCustomers() {

    }

    override fun onCustomerSelected(customer: Customer) {
        view?.openCustomerDetail(customer)
    }

    override fun onAddCustomerClick() {
//        view?.openCustomerNew()
        customerInteractor.saveCustomer(Customer(Date().time, "De Castro"))
    }

    override fun detachView() {
        super.detachView()
        disposables.forEach { if (!it?.isDisposed) dispose() }
    }
}