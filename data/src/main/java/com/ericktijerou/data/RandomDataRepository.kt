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

    override fun clearUsers(): Completable {
        return factory.retrieveCacheDataStore().clearUsers()
    }

    override fun saveUsers(users: List<User>): Completable {
        val userEntities = users.map { userMapper.mapToEntity(it) }
        return saveUsersEntities(userEntities)
    }

    private fun saveUsersEntities(users: List<UserEntity>): Completable {
        return factory.retrieveCacheDataStore().saveUsers(users)
    }

    override fun getUsers(): Single<List<User>> {
        val dataStore = factory.retrieveDataStore()
        return dataStore.getUsers()
            .flatMap {
                if (dataStore is RandomRemoteDataStore) {
                    saveUsersEntities(it).toSingle { it }
                } else {
                    Single.just(it)
                }
            }
            .map { list ->
                list.map { listItem ->
                    userMapper.mapFromEntity(listItem)
                }
            }
    }

}