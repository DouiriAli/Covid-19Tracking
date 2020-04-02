package com.health.covid19app.di

import android.app.Application
import com.health.covid19app.BuildConfig
import com.health.covid19app.common.base.view.BaseActivity
import com.health.covid19app.di.component.ActivitySubComponent
import com.health.covid19app.di.component.AppComponent
import com.health.covid19app.di.component.DaggerAppComponent
import com.health.covid19app.di.module.ActivityModule
import com.health.covid19app.di.module.AppModule
import com.health.covid19app.di.module.DataModule
import com.health.covid19app.di.module.NetworkModule

class Covid19App : Application() {
    lateinit var appComponent: AppComponent
    private var activityComponent: ActivitySubComponent? = null

    override fun onCreate() {
        super.onCreate()
        initDependencies()
    }

    private fun initDependencies() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .networkModule(NetworkModule(BuildConfig.BASE_URL))
            .dataModule(DataModule())
            .build()
    }

    fun createActivityComponent(activity: BaseActivity): ActivitySubComponent {
        activityComponent = appComponent.plus(ActivityModule(activity))
        return activityComponent!!
    }
}