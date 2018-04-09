package it.carusopi.soluzioneagenti.base.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import it.carusopi.soluzioneagenti.base.ViewModelKey
import it.carusopi.soluzioneagenti.base.di.DaggerViewModelFactory
import it.carusopi.soluzioneagenti.customers_list.CustomerListViewModel

/**
 * Created by carusopi on 26/03/2018.
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CustomerListViewModel::class)
    abstract fun bindRepoViewModel(customerListViewModel: CustomerListViewModel) : ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}