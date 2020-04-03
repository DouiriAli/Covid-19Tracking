package com.health.covid19app.di.module

import com.health.data.entity.mapper.CountryMapper
import com.health.data.remote.RemoteService
import com.health.data.repository.Covid19DataStoreFactory
import com.health.data.repository.Covid19RepositoryImpl
import com.health.domain.repository.Covid19Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideCountryCasesRepository(
        factory: Covid19DataStoreFactory,
        mapper: CountryMapper
    ): Covid19Repository =
        Covid19RepositoryImpl(mapper, factory)

    @Provides
    @Singleton
    fun provideUserDataFactory(remote: RemoteService): Covid19DataStoreFactory =
        Covid19DataStoreFactory(remote)

    @Provides
    @Singleton
    fun provideQuizDataMapper(): CountryMapper =
        CountryMapper()
}