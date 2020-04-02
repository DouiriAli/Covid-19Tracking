package com.health.covid19app.common.base.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.health.covid19app.di.component.ActivitySubComponent

abstract class BaseFragment : Fragment(), IView {
    var activity: BaseActivity? = null
    abstract val TAG: String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            this.activity = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    fun getActivityComponent(): ActivitySubComponent? =
        activity?.getActivityComponent()

    override fun navigateTo(fragment: BaseFragment, isAdd: Boolean) {
        activity?.navigateTo(fragment, isAdd)
    }

    override fun navigateTo(activity: BaseActivity) {
        activity.navigateTo(activity)
    }

    override fun hideLoading() {
        activity?.hideLoading()
    }

    override fun showLoading() {
        activity?.showLoading()
    }

    override fun showMessage(message: String) {
        activity?.showMessage(message)
    }
}
