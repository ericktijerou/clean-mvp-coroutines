package com.ericktijerou.domain.interactor.main

import com.ericktijerou.domain.interactor.UseCase
import com.ericktijerou.domain.model.User
import com.ericktijerou.domain.repository.RandomRepository
import javax.inject.Inject

class GetUsers @Inject constructor(val randomRepository: RandomRepository):
        UseCase<List<User>>() {

    override suspend fun executeOnBackground(): List<User> {
        return randomRepository.getUsers()
    }
}