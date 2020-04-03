package com.health.data.remote

import com.health.data.entity.CountryEntity
import com.health.data.entity.VersionEntity
import io.reactivex.Observable

interface RemoteCovid19 {

    fun getVersion(): Observable<VersionEntity>

    fun getCountryCases(): Observable<MutableList<CountryEntity>>
}