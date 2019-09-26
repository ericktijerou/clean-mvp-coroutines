package com.ericktijerou.data

import com.ericktijerou.data.mapper.UserMapper
import com.ericktijerou.data.model.UserEntity
import com.ericktijerou.data.source.RandomDataStoreFactory
import com.ericktijerou.data.source.RandomRemoteDataStore
import com.ericktijerou.domain.model.User
import com.ericktijerou.domain.repository.RandomRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class RandomDataRepository @Inject constructor(private val factory: RandomDataStoreFactory,
                                               private val userMapper: UserMapper
) :
    RandomRepository {

    override suspend fun getUsers(): List<User> {
        val dataStore = factory.retrieveDataStore()
        return dataStore.getUsers().map {
            userMapper.mapFromEntity(it)
        }
    }

}