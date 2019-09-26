package com.ericktijerou.presentation.mapper

import com.ericktijerou.domain.model.Name
import com.ericktijerou.presentation.model.NameView
import javax.inject.Inject

open class NameMapper @Inject constructor(): Mapper<NameView, Name> {

    override fun mapToView(type: Name): NameView {
        return NameView(type.title, type.first, type.last)
    }


}