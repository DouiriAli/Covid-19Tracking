package com.health.covid19app.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.health.covid19app.common.ASyncTransformer
import com.health.covid19app.di.scope.ActivityScope
import com.health.covid19app.ui.CountriesContract
import com.health.covid19app.ui.CountriesPresenter
import com.health.domain.repository.CountryCasesRepository
import com.health.domain.usecases.GetCountryCasesUseCase
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
    fun provideSigninUseCase(repository: CountryCasesRepository): GetCountryCasesUseCase =
        GetCountryCasesUseCase(ASyncTransformer(), repository)

    @Provides
    @ActivityScope
    fun provideCountryCasesPresenter(
        countryCasesUseCase: GetCountryCasesUseCase
    ): CountriesContract.PresenterContract =
        CountriesPresenter(countryCasesUseCase)
}