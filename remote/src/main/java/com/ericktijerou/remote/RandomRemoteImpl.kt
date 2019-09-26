package com.ericktijerou.remote

import com.ericktijerou.data.model.UserEntity
import com.ericktijerou.data.repository.RandomRemote
import com.ericktijerou.remote.mapper.UserEntityMapper
import io.reactivex.Single
import javax.inject.Inject

class RandomRemoteImpl @Inject constructor(private val randomService: RandomService,
                                           private val userEntityMapper: UserEntityMapper
) :

    RandomRemote {

    override suspend fun getUsers(): List<UserEntity> {
        val results = randomService.getUsers().await().results
        return results!!.map {
            userEntityMapper.mapFromRemote(it)
        }
    }

}