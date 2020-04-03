package com.health.covid19app.common.base.view

import com.health.covid19app.common.Utils

interface IView {
    fun showLoading()

    fun hideLoading()

    fun showMessage(message: String, listener: Utils.DialogListener?)

    fun navigateTo(fragment: BaseFragment, isAdd: Boolean)

    fun navigateTo(activity: BaseActivity)
}