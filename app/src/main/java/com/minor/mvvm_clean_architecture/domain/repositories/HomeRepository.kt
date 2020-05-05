package com.minor.mvvm_clean_architecture.domain.repositories

import com.minor.mvvm_clean_architecture.domain.entities.UserEntity
import com.minor.mvvm_clean_architecture.domain.usecases.base.Either
import com.minor.mvvm_clean_architecture.domain.usecases.exception.Failure


interface HomeRepository {
    suspend fun getTopUsers(): Either<Failure, List<UserEntity>>
}