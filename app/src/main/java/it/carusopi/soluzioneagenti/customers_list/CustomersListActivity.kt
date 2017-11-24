package it.carusopi.soluzioneagenti.customers_list

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import it.carusopi.soluzioneagenti.R
import it.carusopi.soluzioneagenti.base.BaseActivity
import it.carusopi.soluzioneagenti.commons.recyclerview.EndlessRecyclerViewScrollListener
import it.carusopi.soluzioneagenti.customers_list.di.CustomersListModule
import it.carusopi.soluzioneagenti.customers_list.di.DaggerCustomersListComponent
import it.carusopi.soluzioneagenti.data.model.CustomerPage
import it.carusopi.soluzioneagenti.list.adapter.CustomersListAdapter
import kotlinx.android.synthetic.main.activity_dashboard.*
import javax.inject.Inject

class CustomersListActivity : BaseActivity(), CustomersListContract.View {

    @Inject
    lateinit var presenter: CustomersListContract.Presenter

    private lateinit var scrollListener: EndlessRecyclerViewScrollListener
    private lateinit var customersAdapter: CustomersListAdapter

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_customers -> {
            }
            R.id.navigation_suppliers -> {
            }
        }
        return@OnNavigationItemSelectedListener true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        initView()

        presenter.loadCustomers()
    }

    private fun initView() {
        initRecycler()
    }

    private fun initRecycler() {
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerCustomers.layoutManager = linearLayoutManager
        scrollListener = object : EndlessRecyclerViewScrollListener(linearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                presenter.loadMoreCustomers()
            }
        }
        recyclerCustomers.addOnScrollListener(scrollListener)

        customersAdapter = CustomersListAdapter(this)
        recyclerCustomers.adapter = customersAdapter
    }

    override fun onActivityInject() {
        DaggerCustomersListComponent.builder()
                .appComponent(getAppcomponent())
                .customersListModule(CustomersListModule())
                .build()
                .inject(this)

        presenter.attachView(this)
    }

    override fun addCustomers(customerPage: CustomerPage) {
        customersAdapter.addCustomers(customerPage)
    }

    override fun showCustomers() {
        recyclerCustomers.visibility = View.VISIBLE
    }

    override fun hideCustomers() {
        recyclerCustomers.visibility = View.GONE
    }

    override fun showListLoading() {
        progressLoader.visibility = View.VISIBLE
    }

    override fun hideListLoading() {
        progressLoader.visibility = View.GONE
    }

    override fun showListError(messageRes: Int) {
    }

    override fun hideListError() {
    }

    override fun showListEmpty() {
    }

    override fun hideListEmpty() {
    }
}
