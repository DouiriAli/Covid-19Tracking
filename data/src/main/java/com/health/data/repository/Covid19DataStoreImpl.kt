package com.health.data.repository

import com.health.data.entity.CountryEntity
import com.health.data.entity.VersionEntity
import com.health.data.remote.RemoteCovid19
import io.reactivex.Observable

class Covid19DataStoreImpl(private val remote: RemoteCovid19) :
    Covid19DataStore {

    override fun getCountryCases(): Observable<MutableList<CountryEntity>> =
        remote.getCountryCases()

    override fun getVersion(): Observable<VersionEntity> =
        remote.getVersion()

}