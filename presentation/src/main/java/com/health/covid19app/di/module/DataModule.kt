package com.health.covid19app.di.module

import com.health.data.entity.mapper.CountryMapper
import com.health.data.remote.RemoteService
import com.health.data.repository.CountryCasesDataStoreFactory
import com.health.data.repository.CountryCasesRepositoryImpl
import com.health.domain.repository.CountryCasesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideCountryCasesRepository(
        factory: CountryCasesDataStoreFactory,
        mapper: CountryMapper
    ): CountryCasesRepository =
        CountryCasesRepositoryImpl(mapper, factory)

    @Provides
    @Singleton
    fun provideUserDataFactory(remote: RemoteService): CountryCasesDataStoreFactory =
        CountryCasesDataStoreFactory(remote)

    @Provides
    @Singleton
    fun provideQuizDataMapper(): CountryMapper =
        CountryMapper()
}