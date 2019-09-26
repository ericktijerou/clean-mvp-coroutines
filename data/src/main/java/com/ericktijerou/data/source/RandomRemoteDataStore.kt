package com.ericktijerou.data.source

import com.ericktijerou.data.model.UserEntity
import com.ericktijerou.data.repository.RandomDataStore
import com.ericktijerou.data.repository.RandomRemote
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

open class RandomRemoteDataStore @Inject constructor(private val randomRemote: RandomRemote) :
    RandomDataStore {

    override fun clearUsers(): Completable {
        throw UnsupportedOperationException()
    }

    override fun saveUsers(users: List<UserEntity>): Completable {
        throw UnsupportedOperationException()
    }

    override fun getUsers(): Single<List<UserEntity>> {
        return randomRemote.getUsers()
    }

}