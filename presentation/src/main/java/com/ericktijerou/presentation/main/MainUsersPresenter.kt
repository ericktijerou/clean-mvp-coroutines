package com.ericktijerou.presentation.main

import com.ericktijerou.domain.interactor.UseCase
import com.ericktijerou.domain.model.User
import com.ericktijerou.presentation.mapper.UserMapper
import javax.inject.Inject

class MainUsersPresenter @Inject constructor(val mainView: MainUsersContract.View,
                                             val getUsersUseCase: UseCase<List<User>>,
                                             val userMapper: UserMapper
):
    MainUsersContract.Presenter {

    init {
        mainView.setPresenter(this)
    }

    override fun start() {
        retrieveUsers()
    }

    override fun stop() {
        getUsersUseCase.unsubscribe()
    }

    override fun retrieveUsers() {
        getUsersUseCase.execute {
            onComplete {
                mainView.hideErrorState()
                if (it.isNotEmpty()) {
                    mainView.hideEmptyState()
                    mainView.showUsers(it.map { userMapper.mapToView(it) })
                } else {
                    mainView.hideUsers()
                    mainView.showEmptyState()
                }
            }
            onError {
                mainView.hideUsers()
                mainView.hideEmptyState()
                mainView.showErrorState()
            }
        }
    }
}