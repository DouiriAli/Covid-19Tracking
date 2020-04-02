package com.health.covid19app.common.base.presenter

import com.health.covid19app.common.base.view.IView

interface IBasePresenter<V : IView> {
    val TAG: String?
    fun attachView(view: V)
    fun detachView()
    fun isViewAttached(): Boolean
}