package com.ericktijerou.mobile_ui.injection.module

import com.ericktijerou.domain.interactor.main.GetUsers
import com.ericktijerou.mobile_ui.injection.scopes.PerActivity
import com.ericktijerou.mobile_ui.main.MainActivity
import com.ericktijerou.presentation.main.MainUsersContract
import com.ericktijerou.presentation.main.MainUsersPresenter
import com.ericktijerou.presentation.mapper.UserMapper
import dagger.Module
import dagger.Provides

@Module
open class MainActivityModule {

    @PerActivity
    @Provides
    internal fun provideBrowseView(mainActivity: MainActivity): MainUsersContract.View {
        return mainActivity
    }

    @PerActivity
    @Provides
    internal fun provideBrowsePresenter(
        mainView: MainUsersContract.View,
        getUsers: GetUsers, mapper: UserMapper
    ):
            MainUsersContract.Presenter {
        return MainUsersPresenter(mainView, getUsers, mapper)
    }

}
