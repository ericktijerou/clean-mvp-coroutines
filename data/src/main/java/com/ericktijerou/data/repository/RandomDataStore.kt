package com.ericktijerou.data.repository

import com.ericktijerou.data.model.UserEntity
import io.reactivex.Completable
import io.reactivex.Single

interface RandomDataStore {

    suspend fun getUsers(): List<UserEntity>

}