package it.carusopi.soluzioneagenti.customer_detail

import it.carusopi.soluzioneagenti.base.mvp.BasePresenter
import it.carusopi.soluzioneagenti.base.mvp.BaseView

/**
 * Created by carusopi on 24/11/2017.
 */
interface CustomerDetailContract {
    abstract class Presenter: BasePresenter<View>(){
    }

    interface View: BaseView {
    }
}