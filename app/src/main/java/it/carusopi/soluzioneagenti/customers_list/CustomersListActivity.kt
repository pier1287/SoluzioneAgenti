package it.carusopi.soluzioneagenti.customers_list

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.View
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import it.carusopi.soluzioneagenti.R
import it.carusopi.soluzioneagenti.base.*
import it.carusopi.soluzioneagenti.commons.recyclerview.EndlessRecyclerViewScrollListener
import it.carusopi.soluzioneagenti.customer_detail.CustomerDetailActivity
import it.carusopi.soluzioneagenti.customer_modify.CustomerModifyActivity
import it.carusopi.soluzioneagenti.data.model.Customer
import it.carusopi.soluzioneagenti.list.adapter.CustomersListAdapter
import kotlinx.android.synthetic.main.activity_customers_list.*
import kotlinx.android.synthetic.main.toolbar_standard.*
import javax.inject.Inject

class CustomersListActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: CustomerListViewModel

    private val compositeDisposable = CompositeDisposable()

    private val customerClick: (Customer) -> Unit = { CustomerDetailActivity.start(this, it) }
    private val newCustomerclick: () -> Unit = { CustomerModifyActivity.start(this) }

    private lateinit var scrollListener: EndlessRecyclerViewScrollListener
    private var customersAdapter = CustomersListAdapter(customerClick)
    private var hasMoreData = false

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

        setContentView(R.layout.activity_customers_list)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        initView()

        withViewModel<CustomerListViewModel>(viewModelFactory) {
            viewModel = this
            observe(customers, ::updateCustomers)

            loadCustomers()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.list_menu, menu)
        return true
    }

    private fun initView() {
        initToolbar()
        initRecycler()
//        RxView.clicks(fabAdd).subscribe { presenter.onAddCustomerClick() }
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
    }

    private fun initRecycler() {
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerCustomers.layoutManager = linearLayoutManager
        scrollListener = EndlessRecyclerViewScrollListener(linearLayoutManager)
        compositeDisposable.add(scrollListener.loadMoreEvent
                .subscribeOn(Schedulers.io())
                .subscribe({ if (hasMoreData) viewModel.loadMoreCustomers() }))

        recyclerCustomers.addOnScrollListener(scrollListener)
        recyclerCustomers.adapter = customersAdapter
    }

    private fun updateCustomers(data: Data<List<Customer>>?) {
        data?.let {
            when (it.dataState) {
                DataState.LOADING -> progressLoader.visibility = View.VISIBLE
                DataState.SUCCESS -> progressLoader.visibility = View.INVISIBLE
                DataState.ERROR -> progressLoader.visibility = View.INVISIBLE
            }

            it.data?.let { customers ->
                customersAdapter.addCustomers(customers, it.hasMoreData)
                recyclerCustomers.visibility = View.VISIBLE
                hasMoreData = it.hasMoreData
            }
        }
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }
}
