package com.health.covid19app.common.base.view

interface IView {
    fun showLoading()

    fun hideLoading()

    fun showMessage(message: String)

    fun navigateTo(fragment: BaseFragment, isAdd: Boolean)

    fun navigateTo(activity: BaseActivity)
}