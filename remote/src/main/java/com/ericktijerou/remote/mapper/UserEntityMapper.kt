package com.ericktijerou.remote.mapper

import com.ericktijerou.data.model.UserEntity
import com.ericktijerou.remote.model.UserModel
import javax.inject.Inject

open class UserEntityMapper @Inject
    constructor(private val nameEntityMapper: NameEntityMapper,
                private val pictureEntityMapper: PictureEntityMapper) :
        EntityMapper<UserModel, UserEntity> {

    override fun mapFromRemote(type: UserModel): UserEntity {
        return UserEntity(nameEntityMapper.mapFromRemote(type.name), type.email, pictureEntityMapper.mapFromRemote(type.picture))
    }

}