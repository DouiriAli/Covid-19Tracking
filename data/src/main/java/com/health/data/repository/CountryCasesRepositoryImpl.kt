package com.health.data.repository

import com.health.data.entity.mapper.CountryMapper
import com.health.domain.model.Country
import com.health.domain.repository.CountryCasesRepository
import io.reactivex.Observable

class CountryCasesRepositoryImpl(
    private val mapper: CountryMapper,
    factory: CountryCasesDataStoreFactory
) : CountryCasesRepository {

    private val dataStore: CountryCasesDataStore

    init {
        dataStore = factory.createCountryCasesDataStore()
    }

    override fun getCountryCases(): Observable<MutableList<Country>> =
        dataStore.getCountryCases().map { mapper.transformCountryEntityCollection(it) }
}