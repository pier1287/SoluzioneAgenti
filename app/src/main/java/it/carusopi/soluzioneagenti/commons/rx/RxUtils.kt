package it.carusopi.soluzioneagenti.commons.rx
import io.reactivex.disposables.Disposable



/**
 * Created by carusopi on 24/11/2017.
 */

fun dispose(disposable: Disposable?) {
    if (disposable != null) {
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }
}

fun dispose(vararg disposables: Disposable?) {
    disposables.map { if (it != null && !it.isDisposed) it.dispose()}
}