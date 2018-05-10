package it.carusopi.soluzioneagenti.customers_list

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import it.carusopi.soluzioneagenti.base.Data
import it.carusopi.soluzioneagenti.base.DataState
import it.carusopi.soluzioneagenti.data.interactor.CustomerInteractor
import it.carusopi.soluzioneagenti.data.model.Customer
import it.carusopi.soluzioneagenti.data.model.CustomerPage
import it.carusopi.soluzioneagenti.data.model.exception.HttpNotFoundException
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by carusopi on 23/03/2018.
 */
class CustomerListViewModel @Inject constructor(private var customerInteractor: CustomerInteractor) : ViewModel() {

    val customers = MutableLiveData<Data<List<Customer>>>()

    private val compositeDisposable = CompositeDisposable()

    fun loadCustomers() {
        customers.postValue(Data(DataState.LOADING))

        compositeDisposable.add(customerInteractor.getCustomers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetCustomerList, this::onGetCustomersListError))
    }

    private fun onGetCustomerList(customerPage: CustomerPage){
        customers.postValue( Data(DataState.SUCCESS, customerPage.customersList, customerPage.hasNextPage()) )
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
        Log.e("", "", ex)
    }

    fun loadMoreCustomers() {
        compositeDisposable.add(customerInteractor.getMoreCustomers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ customers.postValue(Data(DataState.SUCCESS, it.customersList, it.hasNextPage())) },
                        this::onGetCustomersListError))
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}