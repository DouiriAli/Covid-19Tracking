package com.health.covid19app.di.component

import com.health.covid19app.di.module.ActivityModule
import com.health.covid19app.di.scope.ActivityScope
import com.health.covid19app.ui.covid19.CountriesFragment
import com.health.covid19app.ui.splash.SplashScreenActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivitySubComponent {

    fun inject(view: SplashScreenActivity)

    fun inject(view: CountriesFragment)
}