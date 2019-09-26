package com.ericktijerou.presentation

interface BaseView<in T : BasePresenter> {

    fun setPresenter(presenter: T)

}