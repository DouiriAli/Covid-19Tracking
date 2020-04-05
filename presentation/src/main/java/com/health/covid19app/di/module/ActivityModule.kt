package com.health.covid19app.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.health.covid19app.common.ASyncTransformer
import com.health.covid19app.di.scope.ActivityScope
import com.health.covid19app.ui.covid19.CountriesContract
import com.health.covid19app.ui.covid19.CountriesPresenter
import com.health.covid19app.ui.splash.SplashScreenContract
import com.health.covid19app.ui.splash.SplashScreenPresenter
import com.health.domain.repository.Covid19Repository
import com.health.domain.usecases.GetCountryCasesUseCase
import com.health.domain.usecases.GetVersionUseCase
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    fun provideContext(): Context = activity

    @Provides
    fun provideActivity(): AppCompatActivity = activity

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    @ActivityScope
    fun provideCountryCasesUseCase(repository: Covid19Repository): GetCountryCasesUseCase =
        GetCountryCasesUseCase(ASyncTransformer(), repository)

    @Provides
    @ActivityScope
    fun provideVersionUseCase(repository: Covid19Repository): GetVersionUseCase =
        GetVersionUseCase(ASyncTransformer(), repository)

    @Provides
    @ActivityScope
    fun provideCountryCasesPresenter(
        useCase: GetCountryCasesUseCase
    ): CountriesContract.PresenterContract =
        CountriesPresenter(useCase)

    @Provides
    @ActivityScope
    fun provideSplashScreenPresenter(
        useCase: GetVersionUseCase
    ): SplashScreenContract.PresenterContract =
        SplashScreenPresenter(useCase)
}