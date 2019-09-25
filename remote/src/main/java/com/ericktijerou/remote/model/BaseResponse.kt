package com.ericktijerou.remote.model

open class BaseResponse<T> {
    var info: InfoResponse? = null
    var results: T? = null
}