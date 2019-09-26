package com.ericktijerou.ui.mapper

import com.ericktijerou.ui.model.NameViewModel
import com.ericktijerou.presentation.model.NameView
import javax.inject.Inject

open class NameMapper @Inject constructor(): Mapper<NameViewModel, NameView> {

    override fun mapToViewModel(type: NameView): NameViewModel {
        return NameViewModel(type.title, type.first, type.last)
    }

}