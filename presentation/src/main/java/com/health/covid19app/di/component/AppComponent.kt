package com.health.covid19app.di.component

import com.health.covid19app.di.module.ActivityModule
import com.health.covid19app.di.module.AppModule
import com.health.covid19app.di.module.DataModule
import com.health.covid19app.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

const val SCHEDULER_MAIN_THREAD = "mainThread"
const val SCHEDULER_IO = "io"

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, DataModule::class])
interface AppComponent {
    fun plus(activityModule: ActivityModule): ActivitySubComponent
}