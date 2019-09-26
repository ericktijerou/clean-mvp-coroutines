package com.ericktijerou.mobile_ui.injection.module

import com.ericktijerou.mobile_ui.injection.scopes.PerActivity
import com.ericktijerou.mobile_ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity

}