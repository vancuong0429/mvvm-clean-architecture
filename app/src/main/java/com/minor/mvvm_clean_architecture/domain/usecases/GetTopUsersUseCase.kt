package com.minor.mvvm_clean_architecture.domain.usecases

import com.minor.mvvm_clean_architecture.domain.entities.UserEntity
import com.minor.mvvm_clean_architecture.domain.repositories.HomeRepository
import com.minor.mvvm_clean_architecture.domain.usecases.base.Either
import com.minor.mvvm_clean_architecture.domain.usecases.exception.Failure
import com.minor.mvvm_clean_architecture.domain.usecases.base.UseCase
import com.minor.mvvm_clean_architecture.domain.usecases.base.UseCaseParams

class GetTopUsersUseCase(private val homeRepository: HomeRepository) :
    UseCase<UseCaseParams.Empty, List<UserEntity>>() {

    override suspend fun executeInternal(params: UseCaseParams.Empty): Either<Failure, List<UserEntity>> {
        return homeRepository.getTopUsers()
    }
}