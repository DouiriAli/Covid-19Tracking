package com.health.data.remote

import com.health.data.entity.CountryEntity
import com.health.data.entity.VersionEntity
import io.reactivex.Observable

class RemoteCovid19Impl(private val remoteService: RemoteService) : RemoteCovid19 {

    override fun getCountryCases(): Observable<MutableList<CountryEntity>> =
        remoteService.getCountryCases()

    override fun getVersion(): Observable<VersionEntity> =
        remoteService.getVersion()
}