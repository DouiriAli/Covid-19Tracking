package com.health.data.remote

import com.health.data.entity.CountryEntity
import io.reactivex.Observable
import retrofit2.http.GET

interface RemoteService {

    @GET("countries")
    fun getCountryCases(): Observable<MutableList<CountryEntity>>

}