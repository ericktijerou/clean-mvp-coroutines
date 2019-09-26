package com.ericktijerou.domain.interactor.main

import com.ericktijerou.domain.executor.PostExecutionThread
import com.ericktijerou.domain.executor.ThreadExecutor
import com.ericktijerou.domain.interactor.SingleUseCase
import com.ericktijerou.domain.model.User
import com.ericktijerou.domain.repository.RandomRepository
import io.reactivex.Single
import javax.inject.Inject

open class GetUsers @Inject constructor(val randomRepository: RandomRepository,
                                        threadExecutor: ThreadExecutor,
                                        postExecutionThread: PostExecutionThread
):
        SingleUseCase<List<User>, Void?>(threadExecutor, postExecutionThread) {

    public override fun buildUseCaseObservable(params: Void?): Single<List<User>> {
        return randomRepository.getUsers()
    }

}