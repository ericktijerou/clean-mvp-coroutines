package com.ericktijerou.ui.injection.component

import com.ericktijerou.ui.main.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface BrowseActivitySubComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()

}