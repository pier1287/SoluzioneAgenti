package it.carusopi.soluzioneagenti.customer_modify

import android.content.Context
import android.content.Intent
import android.os.Bundle
import it.carusopi.soluzioneagenti.R
import it.carusopi.soluzioneagenti.base.BaseActivity

class CustomerModifyActivity : BaseActivity() {

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

}
