package it.carusopi.soluzioneagenti.commons.realm

import io.reactivex.Observable
import io.realm.RealmResults
import io.realm.RealmChangeListener
import io.reactivex.ObservableEmitter
import io.realm.RealmObject
import io.reactivex.ObservableOnSubscribe



/**
 * Created by carusopi on 12/02/2018.
 */
class RealmResultsObservable<T : RealmObject> private constructor(private val realmResults: RealmResults<T>)
    : ObservableOnSubscribe<RealmResults<T>> {

    @Throws(Exception::class)
    override fun subscribe(emitter: ObservableEmitter<RealmResults<T>>) {
        val changeListener = RealmChangeListener<RealmResults<T>> { emitter.onNext(it) }
        realmResults.addChangeListener(changeListener)
        emitter.setCancellable { realmResults.removeChangeListener(changeListener) }
    }

    companion object {

        fun <T : RealmObject> from(realmResults: RealmResults<T>): Observable<RealmResults<T>> {
            return Observable.create(RealmResultsObservable(realmResults))
        }
    }
}

//fun <T : RealmObject> RealmResults<T>.asObservable() : Observable<RealmResults<T>>{
//    return RealmResultsObservable.from(this)
//}