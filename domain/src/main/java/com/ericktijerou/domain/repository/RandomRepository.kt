package com.ericktijerou.domain.repository

import com.ericktijerou.domain.model.User
import io.reactivex.Completable
import io.reactivex.Single

interface RandomRepository {

    suspend fun getUsers(): List<User>

}