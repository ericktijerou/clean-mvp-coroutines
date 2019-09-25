package com.ericktijerou.data.repository

import com.ericktijerou.data.model.UserEntity
import io.reactivex.Completable
import io.reactivex.Single

interface RandomDataStore {

    fun clearUsers(): Completable

    fun saveUsers(users: List<UserEntity>): Completable

    fun getUsers(): Single<List<UserEntity>>

}