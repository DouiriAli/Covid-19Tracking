package com.health.domain.usecases

import com.health.domain.model.Version
import com.health.domain.repository.Covid19Repository
import com.health.domain.usecases.common.Transformer
import io.reactivex.Observable

class GetVersionUseCase(
    transformer: Transformer<Version>,
    private val repository: Covid19Repository
) :
    UseCase<Version>(transformer) {

    override fun createObservable(data: Map<String, Any>?): Observable<Version> =
        repository.getVersion()
}