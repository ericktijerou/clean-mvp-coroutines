package com.ericktijerou.domain.repository

import com.ericktijerou.domain.model.User
import io.reactivex.Completable
import io.reactivex.Single

interface RandomRepository {

    fun clearUsers(): Completable

    fun saveUsers(users: List<User>): Completable

    fun getUsers(): Single<List<User>>

}