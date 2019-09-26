package com.ericktijerou.data.source

import com.ericktijerou.data.repository.RandomCache
import com.ericktijerou.data.repository.RandomDataStore
import javax.inject.Inject


open class RandomDataStoreFactory @Inject constructor(
    private val randomRemoteDataStore: RandomRemoteDataStore
) {

    open fun retrieveDataStore(): RandomDataStore {
        return retrieveRemoteDataStore()
    }

    open fun retrieveRemoteDataStore(): RandomDataStore {
        return randomRemoteDataStore
    }

}