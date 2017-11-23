package it.carusopi.soluzioneagenti.base.mvp

/**
 * Created by carusopi on 26/10/2017.
 */
interface Presenter<in V: BaseView> {
    fun attachView(view: V)
    fun detachView()
}