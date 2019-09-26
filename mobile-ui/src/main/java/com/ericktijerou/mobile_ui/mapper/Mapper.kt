package com.ericktijerou.mobile_ui.mapper

interface Mapper<out V, in D> {

    fun mapToViewModel(type: D): V

}