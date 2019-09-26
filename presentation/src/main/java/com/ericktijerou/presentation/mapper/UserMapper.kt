package com.ericktijerou.presentation.mapper

import com.ericktijerou.domain.model.User
import com.ericktijerou.presentation.model.UserView
import javax.inject.Inject

open class UserMapper @Inject
    constructor(private val nameMapper: NameMapper,
                private val pictureMapper: PictureMapper):
        Mapper<UserView, User> {

    override fun mapToView(type: User): UserView {
        return UserView(nameMapper.mapToView(type.name), type.email, pictureMapper.mapToView(type.picture))
    }

}