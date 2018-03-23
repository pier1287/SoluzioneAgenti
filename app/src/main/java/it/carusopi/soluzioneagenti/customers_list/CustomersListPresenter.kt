package it.carusopi.soluzioneagenti.customers_list

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import it.carusopi.soluzioneagenti.commons.rx.dispose
import it.carusopi.soluzioneagenti.data.interactor.CustomerInteractor
import it.carusopi.soluzioneagenti.data.model.Customer
import it.carusopi.soluzioneagenti.data.model.CustomerPage
import it.carusopi.soluzioneagenti.data.model.exception.HttpNotFoundException
import javax.inject.Inject

/**
 * Created by carusopi on 23/11/2017.
 */
class CustomersListPresenter @Inject constructor(private var customerInteractor: CustomerInteractor): CustomersListContract.Presenter() {

    private var getCustomerDisposable: Disposable? = null
    private var getMoreCustomersDisposable: Disposable? = null

    override fun loadCustomers() {
        view?.showListLoading()
        disposables.add(
                customerInteractor.getCustomers()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::onGetCustomersListSuccess, this::onGetCustomersListError))

    }

    private fun onGetCustomersListError(ex: Throwable?) {
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
        if (customerPage.isEmpty()){ view?.showListEmpty() }
        else { 
            view?.addCustomers(customerPage) 
            view?.showCustomers()
        }
        view?.hideListLoading()
    }

    override fun loadMoreCustomers() {
        disposables.add(
                customerInteractor.getMoreCustomers()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::onGetCustomersListSuccess, this::onGetCustomersListError))
    }

    override fun onCustomerSelected(customer: Customer) {
        view?.openCustomerDetail(customer)
    }

    override fun onAddCustomerClick() {
        view?.openCustomerNew()
    }

    override fun detachView() {
        super.detachView()
        dispose(getCustomerDisposable, getMoreCustomersDisposable)
    }
}