package com.health.domain.usecases

import com.health.domain.model.Country
import com.health.domain.repository.CountryCasesRepository
import com.health.domain.usecases.common.Transformer
import io.reactivex.Observable

class GetCountryCasesUseCase(
    transformer: Transformer<MutableList<Country>>,
    private val repository: CountryCasesRepository
) :
    UseCase<MutableList<Country>>(transformer) {

    override fun createObservable(data: Map<String, Any>?): Observable<MutableList<Country>> =
        repository.getCountryCases()
}