package it.carusopi.soluzioneagenti.customers_list

import android.support.annotation.StringRes
import it.carusopi.soluzioneagenti.base.mvp.BasePresenter
import it.carusopi.soluzioneagenti.base.mvp.BaseView
import it.carusopi.soluzioneagenti.data.model.Customer
import it.carusopi.soluzioneagenti.data.model.CustomerPage

/**
 * Created by carusopi on 23/11/2017.
 */
interface CustomersListContract {
    abstract class Presenter: BasePresenter<View>(){
        abstract fun loadCustomers()
        abstract fun loadMoreCustomers()
        abstract fun onCustomerSelected(customer: Customer)
        abstract fun onAddCustomerClick()
    }

    interface View: BaseView{
        fun showCustomers(customerPage: CustomerPage)
        fun addMoreCustomers(customerPage: CustomerPage)
        fun hideCustomers()
        fun showListLoading()
        fun hideListLoading()
        fun showListError(@StringRes messageRes: Int)
        fun hideListError()
        fun showListEmpty()
        fun hideListEmpty()
        fun openCustomerDetail(customer: Customer)
        fun openCustomerNew()
    }
}