package com.health.data.remote

import com.health.data.entity.CountryEntity
import io.reactivex.Observable

interface CountryCases {

    fun getCountryCases(): Observable<MutableList<CountryEntity>>
}