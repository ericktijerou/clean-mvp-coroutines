package com.ericktijerou.mobile_ui.mapper

import com.ericktijerou.mobile_ui.model.PictureViewModel
import com.ericktijerou.presentation.model.PictureView
import javax.inject.Inject

open class PictureMapper @Inject constructor(): Mapper<PictureViewModel, PictureView> {

    override fun mapToViewModel(type: PictureView): PictureViewModel {
        return PictureViewModel(type.large, type.medium, type.thumbnail)
    }

}