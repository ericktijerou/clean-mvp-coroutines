package com.ericktijerou.remote

import com.ericktijerou.remote.model.BaseResponse
import com.ericktijerou.remote.model.UserModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface RandomService {
    @GET("api/?results=50")
    fun getUsers(): Deferred<BaseResponse<List<UserModel>>>
}