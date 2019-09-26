package com.ericktijerou.data.mapper

import com.ericktijerou.data.model.NameEntity
import com.ericktijerou.domain.model.Name
import javax.inject.Inject

open class NameMapper @Inject constructor(): Mapper<NameEntity, Name> {

    override fun mapFromEntity(type: NameEntity): Name {
        return Name(type.title, type.first, type.last)
    }

    override fun mapToEntity(type: Name): NameEntity {
        return NameEntity(type.title, type.first, type.last)
    }


}