package com.health.covid19app.ui

import com.health.covid19app.common.base.presenter.IBasePresenter
import com.health.covid19app.common.base.view.IView
import com.health.domain.model.Country

interface CountryCasesContract {

    interface PresenterContract : IBasePresenter<ViewContract> {
        fun getCountryCases()
    }

    interface ViewContract : IView {
        fun onCountryCasesReady(result: MutableList<Country>)
    }
}