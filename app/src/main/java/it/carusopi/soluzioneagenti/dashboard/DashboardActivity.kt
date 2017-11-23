package it.carusopi.soluzioneagenti.dashboard

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import it.carusopi.soluzioneagenti.R
import it.carusopi.soluzioneagenti.base.BaseActivity
import it.carusopi.soluzioneagenti.dashboard.di.DaggerDashboardComponent
import it.carusopi.soluzioneagenti.dashboard.di.DashboardModule
import kotlinx.android.synthetic.main.activity_dashboard.*
import javax.inject.Inject

class DashboardActivity : BaseActivity(), DashboardContract.View {

    @Inject
    lateinit var presenter: DashboardContract.Presenter

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_customers -> {
                message.setText(R.string.title_customers)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_suppliers -> {
                message.setText(R.string.title_suppliers)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun onActivityInject() {
        DaggerDashboardComponent.builder()
                .appComponent(getAppcomponent())
                .dashboardModule(DashboardModule())
                .build()
                .inject(this)

        presenter.attachView(this)
    }
}
