package com.ericktijerou.data.repository

import com.ericktijerou.data.model.UserEntity
import io.reactivex.Completable
import io.reactivex.Single

interface RandomCache {

    fun clearUsers(): Completable

    fun saveUsers(users: List<UserEntity>): Completable

    fun getUsers(): Single<List<UserEntity>>

    fun isCached(): Boolean

    fun setLastCacheTime(lastCache: Long)

    fun isExpired(): Boolean

}