package com.health.domain.repository

import com.health.domain.model.Country
import com.health.domain.model.Version
import io.reactivex.Observable

interface Covid19Repository {

    fun getCountryCases(): Observable<MutableList<Country>>

    fun getVersion(): Observable<Version>

}