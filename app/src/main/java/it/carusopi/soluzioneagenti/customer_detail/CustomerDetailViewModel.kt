package it.carusopi.soluzioneagenti.customer_detail

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import it.carusopi.soluzioneagenti.base.Data
import it.carusopi.soluzioneagenti.data.interactor.CustomerInteractor
import it.carusopi.soluzioneagenti.data.model.Customer
import org.jetbrains.annotations.NotNull
import it.carusopi.soluzioneagenti.base.DataState
import javax.inject.Inject

/**
 * Created by carusopi on 09/04/2018.
 */
class CustomerDetailViewModel @Inject
constructor(private var customerInteractor: CustomerInteractor) : ViewModel() {

    val customerDetail = MutableLiveData<Data<Customer>>()

    fun loadCustomerDetails(@NotNull idCustomer: Long){
        customerInteractor.getCustomerDetails(idCustomer)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { customerDetail.postValue(Data(DataState.SUCCESS, it))},
                        { Log.e("","", it) }
                )
    }

}