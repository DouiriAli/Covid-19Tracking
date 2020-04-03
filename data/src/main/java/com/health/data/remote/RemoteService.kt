package com.health.data.remote

import com.health.data.entity.CountryEntity
import com.health.data.entity.VersionEntity
import io.reactivex.Observable
import retrofit2.http.GET

interface RemoteService {

    @GET("covid19Api/countries.php")
    fun getCountryCases(): Observable<MutableList<CountryEntity>>

    @GET("covid19Api/version.php")
    fun getVersion(): Observable<VersionEntity>

}