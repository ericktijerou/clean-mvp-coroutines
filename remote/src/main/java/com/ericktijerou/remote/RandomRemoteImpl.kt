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

    override fun getUsers(): Single<List<UserEntity>> {
        return randomService.getUsers()
            .map {
                it.results!!.map { listItem ->
                    userEntityMapper.mapFromRemote(listItem)
                }
            }
    }
}