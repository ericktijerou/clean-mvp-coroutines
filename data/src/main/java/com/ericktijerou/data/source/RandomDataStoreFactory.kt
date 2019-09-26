package com.ericktijerou.data.source

import com.ericktijerou.data.repository.RandomCache
import com.ericktijerou.data.repository.RandomDataStore
import javax.inject.Inject


open class RandomDataStoreFactory @Inject constructor(
    private val randomCache: RandomCache,
    private val randomCacheDataStore: RandomCacheDataStore,
    private val randomRemoteDataStore: RandomRemoteDataStore
) {

    open fun retrieveDataStore(): RandomDataStore {
        if (randomCache.isCached() && !randomCache.isExpired()) {
            return retrieveCacheDataStore()
        }
        return retrieveRemoteDataStore()
    }

    open fun retrieveCacheDataStore(): RandomDataStore {
        return randomCacheDataStore
    }

    open fun retrieveRemoteDataStore(): RandomDataStore {
        return randomRemoteDataStore
    }

}