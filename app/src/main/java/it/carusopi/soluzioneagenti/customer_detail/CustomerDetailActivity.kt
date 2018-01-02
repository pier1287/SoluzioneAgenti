package it.carusopi.soluzioneagenti.customer_detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import it.carusopi.soluzioneagenti.R
import it.carusopi.soluzioneagenti.base.BaseActivity
import it.carusopi.soluzioneagenti.customer_detail.di.CustomerDetailModule
import it.carusopi.soluzioneagenti.customer_detail.di.DaggerCustomerDetailComponent
import javax.inject.Inject

/**
 * Created by carusopi on 24/11/2017.
 */
class CustomerDetailActivity : BaseActivity(), CustomerDetailContract.View {

    @Inject
    lateinit var presenter: CustomerDetailContract.Presenter

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, CustomerDetailActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onActivityInject() {
        DaggerCustomerDetailComponent.builder()
                .appComponent(getAppcomponent())
                .customerDetailModule(CustomerDetailModule())
                .build().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_customer_detail)
    }
}