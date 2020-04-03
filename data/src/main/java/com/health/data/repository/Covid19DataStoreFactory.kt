package com.health.data.repository

import com.health.data.remote.RemoteCovid19Impl
import com.health.data.remote.RemoteService

class Covid19DataStoreFactory(private val remoteService: RemoteService) {

    fun createCovid19DataStore(): Covid19DataStore {
        val remoteCovid19Impl = RemoteCovid19Impl(remoteService)
        return Covid19DataStoreImpl(remoteCovid19Impl)
    }
}