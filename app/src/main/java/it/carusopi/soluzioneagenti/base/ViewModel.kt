package it.carusopi.soluzioneagenti.base

import android.arch.lifecycle.*
import android.support.v4.app.FragmentActivity
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Created by carusopi on 08/04/2018.
 */

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

enum class DataState { LOADING, SUCCESS, ERROR }

data class Data<out T> constructor(val dataState: DataState,
                                   val data: T? = null,
                                   val hasMoreData: Boolean = false,
                                   val message: Message? = null)

data class Message(val title: String? = null, val message: String? = null)

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(viewModelFactory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, viewModelFactory)[T::class.java]
}

inline fun <reified T : ViewModel> FragmentActivity.withViewModel(viewModelFactory: ViewModelProvider.Factory, body: T.() -> Unit): T {
    val vm = getViewModel<T>(viewModelFactory)
    vm.body()
    return vm
}

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) {
    liveData.observe(this, Observer(body))
}