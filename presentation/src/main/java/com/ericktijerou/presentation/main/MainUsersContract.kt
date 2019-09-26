package com.ericktijerou.presentation.main

import com.ericktijerou.presentation.BasePresenter
import com.ericktijerou.presentation.BaseView
import com.ericktijerou.presentation.model.UserView

interface MainUsersContract {

    interface View : BaseView<Presenter> {

        fun showProgress()

        fun hideProgress()

        fun showUsers(users: List<UserView>)

        fun hideUsers()

        fun showErrorState()

        fun hideErrorState()

        fun showEmptyState()

        fun hideEmptyState()

    }

    interface Presenter : BasePresenter {

        fun retrieveUsers()

    }

}