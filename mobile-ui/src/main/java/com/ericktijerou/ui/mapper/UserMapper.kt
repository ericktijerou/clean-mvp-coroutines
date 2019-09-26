package com.ericktijerou.ui.mapper

import com.ericktijerou.ui.model.UserViewModel
import com.ericktijerou.presentation.model.UserView
import javax.inject.Inject

open class UserMapper @Inject
    constructor(val nameMapper: NameMapper,
                val pictureMapper: PictureMapper):
        Mapper<UserViewModel, UserView> {

    override fun mapToViewModel(type: UserView): UserViewModel {
        return UserViewModel(nameMapper.mapToViewModel(type.name), type.email, pictureMapper.mapToViewModel(type.picture))
    }

}