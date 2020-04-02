package com.health.domain.repository

import com.health.domain.model.Country
import io.reactivex.Observable

interface CountryCasesRepository {

    fun getCountryCases(): Observable<MutableList<Country>>
}