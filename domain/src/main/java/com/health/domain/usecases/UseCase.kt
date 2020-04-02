package com.health.domain.usecases

import com.health.domain.usecases.common.Transformer
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class UseCase<T>(private val transformer: Transformer<T>) {

    private val disposables: CompositeDisposable? = null

    abstract fun createObservable(data: Map<String, Any>? = null): Observable<T>

    fun observable(withData: Map<String, Any>? = null): Observable<T> {
        return createObservable(withData).compose(transformer)
    }

    fun dispose() {
        if (!disposables?.isDisposed!!) {
            disposables.dispose()
        }
    }

    private fun addDisposable(disposable: Disposable) {
        disposables?.add(disposable)
    }
}
