package com.ericktijerou.domain.repository

import com.ericktijerou.domain.model.User

interface RandomRepository {

    suspend fun getUsers(): List<User>

}