package com.health.data.remote

import com.health.data.entity.CountryEntity
import io.reactivex.Observable

class CountryCasesImpl(private val remoteService: RemoteService) : CountryCases {

    override fun getCountryCases(): Observable<MutableList<CountryEntity>> =
        remoteService.getCountryCases()
}