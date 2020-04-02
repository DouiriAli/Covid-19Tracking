package com.health.covid19app.di.module

import android.content.Context
import com.health.covid19app.di.component.SCHEDULER_IO
import com.health.covid19app.di.component.SCHEDULER_MAIN_THREAD
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule constructor(context: Context) {
    private val appContext = context.applicationContext

    @Singleton
    @Provides
    fun provideAppContext(): Context = appContext

    @Provides
    @Named(SCHEDULER_MAIN_THREAD)
    fun provideAndroidMainThreadScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Provides
    @Named(SCHEDULER_IO)
    fun provideIoScheduler(): Scheduler = Schedulers.io()
}