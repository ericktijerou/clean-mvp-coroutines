package com.ericktijerou.data.source

import com.ericktijerou.data.model.UserEntity
import com.ericktijerou.data.repository.RandomCache
import com.ericktijerou.data.repository.RandomDataStore
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

open class RandomCacheDataStore @Inject constructor(private val randomCache: RandomCache) :
    RandomDataStore {

    override fun clearUsers(): Completable {
        return randomCache.clearUsers()
    }

    override fun saveUsers(users: List<UserEntity>): Completable {
        return randomCache.saveUsers(users)
                .doOnComplete {
                    randomCache.setLastCacheTime(System.currentTimeMillis())
                }
    }

    override fun getUsers(): Single<List<UserEntity>> {
        return randomCache.getUsers()
    }

}