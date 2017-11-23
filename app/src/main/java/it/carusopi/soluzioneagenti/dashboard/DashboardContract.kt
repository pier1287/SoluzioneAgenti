package it.carusopi.soluzioneagenti.dashboard

import it.carusopi.soluzioneagenti.base.mvp.BasePresenter
import it.carusopi.soluzioneagenti.base.mvp.BaseView

/**
 * Created by carusopi on 23/11/2017.
 */
interface DashboardContract {
    abstract class Presenter: BasePresenter<View>(){}

    interface View: BaseView{}
}