package com.ericktijerou.ui.mapper

interface Mapper<out V, in D> {

    fun mapToViewModel(type: D): V

}