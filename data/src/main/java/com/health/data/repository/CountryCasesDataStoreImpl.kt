package com.health.data.repository

import com.health.data.entity.CountryEntity
import com.health.data.remote.CountryCases
import io.reactivex.Observable

class CountryCasesDataStoreImpl(private val countryCases: CountryCases) :
    CountryCasesDataStore {

    override fun getCountryCases(): Observable<MutableList<CountryEntity>> =
        countryCases.getCountryCases()
}