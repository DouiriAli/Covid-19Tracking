package com.health.covid19app.ui.splash

import android.util.Log
import com.health.covid19app.common.base.presenter.BasePresenter
import com.health.domain.usecases.GetVersionUseCase

class SplashScreenPresenter(private val usecase: GetVersionUseCase) :
    BasePresenter<SplashScreenContract.ViewContract>(),
    SplashScreenContract.PresenterContract {

    override fun getVersion() {
        usecase.observable().subscribe(
            {
                Log.d(TAG, "onSuccess : $it")
                if (!isViewAttached()) return@subscribe
                view?.onVersionReady(it)
            },
            {
                Log.e(TAG, "onFailure : ${it.message}")
                if (!isViewAttached()) return@subscribe
            })?.let {
            compositeDisposable?.add(it)
        }
    }
}