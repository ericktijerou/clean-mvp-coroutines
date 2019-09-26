package com.ericktijerou.ui.injection.module

import com.ericktijerou.ui.injection.scopes.PerActivity
import com.ericktijerou.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity

}