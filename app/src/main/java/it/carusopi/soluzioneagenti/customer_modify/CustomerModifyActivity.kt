package it.carusopi.soluzioneagenti.customer_modify

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.View
import it.carusopi.soluzioneagenti.R
import it.carusopi.soluzioneagenti.base.BaseActivity
import it.carusopi.soluzioneagenti.commons.recyclerview.EndlessRecyclerViewScrollListener
import it.carusopi.soluzioneagenti.customer_detail.CustomerDetailActivity
import it.carusopi.soluzioneagenti.customer_modify.di.CustomerModifyModule
import it.carusopi.soluzioneagenti.customer_modify.di.DaggerCustomerModifyComponent
import it.carusopi.soluzioneagenti.customers_list.di.CustomersListModule
import it.carusopi.soluzioneagenti.customers_list.di.DaggerCustomersListComponent
import it.carusopi.soluzioneagenti.data.model.CustomerPage
import it.carusopi.soluzioneagenti.list.adapter.CustomersListAdapter
import kotlinx.android.synthetic.main.activity_customers_list.*
import javax.inject.Inject

class CustomerModifyActivity : BaseActivity(), CustomerModifyContract.View {

    @Inject
    lateinit var presenter: CustomerModifyContract.Presenter

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, CustomerModifyActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_modify)

        initView()
    }

    private fun initView() {

    }

    override fun onActivityInject() {
        DaggerCustomerModifyComponent.builder()
                .appComponent(getAppcomponent())
                .customerModifyModule(CustomerModifyModule())
                .build().inject(this)
        presenter.attachView(this)
    }
}
