package com.ericktijerou.domain.model

data class Error(
    val message: String?,
    val code: Int?,
    @Transient var errorStatus: ErrorStatus
) {
    constructor(errorStatus: ErrorStatus) : this(null, null, errorStatus)
}