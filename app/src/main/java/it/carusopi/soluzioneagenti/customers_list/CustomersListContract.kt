package it.carusopi.soluzioneagenti.customers_list

import android.support.annotation.StringRes
import it.carusopi.soluzioneagenti.base.mvp.BasePresenter
import it.carusopi.soluzioneagenti.base.mvp.BaseView
import it.carusopi.soluzioneagenti.data.model.CustomerPage

/**
 * Created by carusopi on 23/11/2017.
 */
interface CustomersListContract {
    abstract class Presenter: BasePresenter<View>(){
        abstract fun loadCustomers()
        abstract fun loadMoreCustomers()
    }

    interface View: BaseView{
        fun addCustomers(customerPage: CustomerPage)
        fun showCustomers()
        fun hideCustomers()
        fun showListLoading()
        fun hideListLoading()
        fun showListError(@StringRes messageRes: Int)
        fun hideListError()
        fun showListEmpty()
        fun hideListEmpty()
    }
}