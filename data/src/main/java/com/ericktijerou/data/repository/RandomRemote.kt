package com.ericktijerou.data.repository

import com.ericktijerou.data.model.UserEntity
import io.reactivex.Single

interface RandomRemote {

    fun getUsers(): Single<List<UserEntity>>

}