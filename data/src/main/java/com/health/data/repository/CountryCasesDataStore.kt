package com.health.data.repository

import com.health.data.entity.CountryEntity
import io.reactivex.Observable

interface CountryCasesDataStore {

    fun getCountryCases(): Observable<MutableList<CountryEntity>>
}