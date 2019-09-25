package com.ericktijerou.remote.mapper

import com.ericktijerou.data.model.PictureEntity
import com.ericktijerou.remote.model.PictureModel
import javax.inject.Inject

open class PictureEntityMapper @Inject constructor(): EntityMapper<PictureModel, PictureEntity> {
    override fun mapFromRemote(type: PictureModel): PictureEntity {
        return PictureEntity(type.large, type.medium, type.thumbnail)
    }
}