package com.ericktijerou.data.mapper

import com.ericktijerou.data.model.PictureEntity
import com.ericktijerou.domain.model.Picture
import javax.inject.Inject

open class PictureMapper @Inject constructor(): Mapper<PictureEntity, Picture> {

    override fun mapFromEntity(type: PictureEntity): Picture {
        return Picture(type.large, type.medium, type.thumbnail)
    }

    override fun mapToEntity(type: Picture): PictureEntity {
        return PictureEntity(type.large, type.medium, type.thumbnail)
    }


}