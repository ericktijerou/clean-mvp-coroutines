package com.ericktijerou.ui.injection.module

import android.app.Application
import android.content.Context
import com.ericktijerou.data.RandomDataRepository
import com.ericktijerou.data.executor.JobExecutor
import com.ericktijerou.data.mapper.UserMapper
import com.ericktijerou.data.repository.RandomRemote
import com.ericktijerou.data.source.RandomDataStoreFactory
import com.ericktijerou.domain.executor.PostExecutionThread
import com.ericktijerou.domain.executor.ThreadExecutor
import com.ericktijerou.domain.repository.RandomRepository
import com.ericktijerou.ui.BuildConfig
import com.ericktijerou.ui.UiThread
import com.ericktijerou.ui.injection.scopes.PerApplication
import com.ericktijerou.remote.RandomRemoteImpl
import com.ericktijerou.remote.RandomService
import com.ericktijerou.remote.RandomServiceFactory
import com.ericktijerou.remote.mapper.UserEntityMapper
import dagger.Module
import dagger.Provides

@Module
open class ApplicationModule {

    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @PerApplication
    internal fun provideRandomRepository(
        factory: RandomDataStoreFactory,
        mapper: UserMapper
    ): RandomRepository {
        return RandomDataRepository(factory, mapper)
    }

    @Provides
    @PerApplication
    internal fun provideRandomRemote(
        service: RandomService,
        factory: UserEntityMapper
    ): RandomRemote {
        return RandomRemoteImpl(service, factory)
    }

    @Provides
    @PerApplication
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @PerApplication
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @PerApplication
    internal fun provideRandomService(): RandomService {
        return RandomServiceFactory.makeRandomService(BuildConfig.DEBUG)
    }
}
