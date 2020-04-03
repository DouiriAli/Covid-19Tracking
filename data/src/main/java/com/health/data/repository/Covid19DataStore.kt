package com.health.data.repository

import com.health.data.entity.CountryEntity
import com.health.data.entity.VersionEntity
import io.reactivex.Observable

interface Covid19DataStore {

    fun getCountryCases(): Observable<MutableList<CountryEntity>>

    fun getVersion(): Observable<VersionEntity>
}