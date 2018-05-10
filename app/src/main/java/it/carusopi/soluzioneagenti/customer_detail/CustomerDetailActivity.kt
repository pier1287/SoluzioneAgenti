package it.carusopi.soluzioneagenti.customer_detail

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.content.Intent
import android.os.Bundle
import it.carusopi.soluzioneagenti.R
import it.carusopi.soluzioneagenti.base.BaseActivity
import it.carusopi.soluzioneagenti.data.model.Customer
import kotlinx.android.synthetic.main.toolbar_collapsing.*
import javax.inject.Inject

/**
 * Created by carusopi on 24/11/2017.
 */
class CustomerDetailActivity : BaseActivity(){

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var customer: Customer

    companion object {
        private const val ARG_CUSTOMER = "ARG_CUSTOMER"

        fun start(context: Context, customer: Customer) {
            val intent = Intent(context, CustomerDetailActivity::class.java)
            intent.putExtra(ARG_CUSTOMER, customer)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getExtra()

        setContentView(R.layout.activity_customer_detail)
        initView()
    }

    private fun getExtra() {
        customer = intent.getParcelableExtra(ARG_CUSTOMER)
    }

    private fun initView() {
        initToolbar()
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        toolbar_layout.title = customer.businessName
    }
}