package com.health.covid19app.common.base.presenter

import com.health.covid19app.common.base.view.IView
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.annotations.Nullable
import javax.inject.Inject

open class BasePresenter<V : IView>() : IBasePresenter<V> {
    protected var view: V? = null

    override val TAG: String
        get() = this::class.java.simpleName

    protected var compositeDisposable: CompositeDisposable? = null

    @Inject
    constructor(@Nullable compositeDisposable: CompositeDisposable) : this() {
        this.compositeDisposable = compositeDisposable
    }

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        compositeDisposable?.dispose()
        if (view != null) view = null
    }

    override fun isViewAttached(): Boolean = view != null

    fun checkViewAttached() {
        if (!isViewAttached()) throw ViewNotAttachedException()
    }

    class ViewNotAttachedException :
        RuntimeException("Please call Presenter.attachView(view) before" + " requesting data to the Presenter")
}