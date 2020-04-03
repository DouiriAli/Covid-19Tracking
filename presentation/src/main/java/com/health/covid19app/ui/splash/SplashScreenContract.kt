package com.health.covid19app.ui.splash

import com.health.covid19app.common.base.presenter.IBasePresenter
import com.health.covid19app.common.base.view.IView
import com.health.domain.model.Version

interface SplashScreenContract {

    interface PresenterContract : IBasePresenter<ViewContract> {
        fun getVersion()
    }

    interface ViewContract : IView {
        fun onVersionReady(version: Version)
    }
}