package com.health.covid19app.ui.covid19

import android.util.Log
import com.health.covid19app.common.base.presenter.BasePresenter
import com.health.domain.usecases.GetCountryCasesUseCase

class CountriesPresenter(private val usecase: GetCountryCasesUseCase) :
    BasePresenter<CountriesContract.ViewContract>(),
    CountriesContract.PresenterContract {

    override fun getCountryCases() {
        view?.showLoading()
        usecase.observable().subscribe(
            {
                Log.d(TAG, "onSuccess : $it")
                if (!isViewAttached()) return@subscribe
                view?.hideLoading()
                view?.onCountryCasesReady(it)
            },
            {
                Log.e(TAG, "onFailure : ${it.message}")
                if (!isViewAttached()) return@subscribe
                view?.hideLoading()
            })?.let {
            compositeDisposable?.add(it)
        }
    }
}