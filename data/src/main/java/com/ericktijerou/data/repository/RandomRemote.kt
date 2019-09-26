package com.ericktijerou.data.repository

import com.ericktijerou.data.model.UserEntity
import io.reactivex.Single

interface RandomRemote {
    suspend fun getUsers(): List<UserEntity>
}