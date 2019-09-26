package com.ericktijerou.ui.mapper

import com.ericktijerou.ui.model.PictureViewModel
import com.ericktijerou.presentation.model.PictureView
import javax.inject.Inject

open class PictureMapper @Inject constructor(): Mapper<PictureViewModel, PictureView> {

    override fun mapToViewModel(type: PictureView): PictureViewModel {
        return PictureViewModel(type.large, type.medium, type.thumbnail)
    }

}