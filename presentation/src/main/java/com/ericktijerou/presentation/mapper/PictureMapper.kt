package com.ericktijerou.presentation.mapper

import com.ericktijerou.domain.model.Picture
import com.ericktijerou.presentation.model.PictureView
import javax.inject.Inject


open class PictureMapper @Inject constructor(): Mapper<PictureView, Picture> {

    override fun mapToView(type: Picture): PictureView {
        return PictureView(type.large, type.medium, type.thumbnail)
    }


}