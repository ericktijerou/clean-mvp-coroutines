package com.ericktijerou.remote.mapper

import com.ericktijerou.data.model.NameEntity
import com.ericktijerou.remote.model.NameModel
import javax.inject.Inject

open class NameEntityMapper @Inject constructor(): EntityMapper<NameModel, NameEntity> {

    override fun mapFromRemote(type: NameModel): NameEntity {
        return NameEntity(type.title, type.first, type.last)
    }

}