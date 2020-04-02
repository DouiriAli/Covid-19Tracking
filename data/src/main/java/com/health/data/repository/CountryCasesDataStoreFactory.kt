package com.health.data.repository

import com.health.data.remote.CountryCasesImpl
import com.health.data.remote.RemoteService

class CountryCasesDataStoreFactory(private val remoteService: RemoteService) {

    fun createCountryCasesDataStore(): CountryCasesDataStore {
        val countryCasesImpl = CountryCasesImpl(remoteService)
        return CountryCasesDataStoreImpl(countryCasesImpl)
    }
}