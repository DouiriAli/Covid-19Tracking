package com.health.data.repository

import com.health.data.entity.extension.transform
import com.health.data.entity.mapper.CountryMapper
import com.health.domain.model.Country
import com.health.domain.model.Version
import com.health.domain.repository.Covid19Repository
import io.reactivex.Observable

class Covid19RepositoryImpl(
    private val mapper: CountryMapper,
    factory: Covid19DataStoreFactory
) : Covid19Repository {

    private val dataStore: Covid19DataStore

    init {
        dataStore = factory.createCovid19DataStore()
    }

    override fun getCountryCases(): Observable<MutableList<Country>> =
        dataStore.getCountryCases().map { mapper.transformCountryEntityCollection(it.asReversed()) }

    override fun getVersion(): Observable<Version> =
        dataStore.getVersion().map { it.transform() }

}