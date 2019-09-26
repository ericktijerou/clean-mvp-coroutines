package com.ericktijerou.data.mapper

import com.ericktijerou.data.model.UserEntity
import com.ericktijerou.domain.model.User
import javax.inject.Inject

open class UserMapper @Inject
    constructor(private val nameMapper: NameMapper,
                private val pictureMapper: PictureMapper
):
    Mapper<UserEntity, User> {

    override fun mapFromEntity(type: UserEntity): User {
        return User(nameMapper.mapFromEntity(type.name), type.email, pictureMapper.mapFromEntity(type.picture))
    }

    override fun mapToEntity(type: User): UserEntity {
        return UserEntity(nameMapper.mapToEntity(type.name), type.email, pictureMapper.mapToEntity(type.picture))
    }


}