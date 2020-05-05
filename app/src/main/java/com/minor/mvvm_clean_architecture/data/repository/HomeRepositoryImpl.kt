package com.minor.mvvm_clean_architecture.data.repository


import com.minor.mvvm_clean_architecture.data.local.dao.UserDao
import com.minor.mvvm_clean_architecture.data.remote.UserService
import com.minor.mvvm_clean_architecture.data.repository.mapper.UserLocalEntityMapper
import com.minor.mvvm_clean_architecture.data.repository.mapper.UserResponseLocalMapper
import com.minor.mvvm_clean_architecture.domain.entities.UserEntity
import com.minor.mvvm_clean_architecture.domain.repositories.HomeRepository
import com.minor.mvvm_clean_architecture.domain.usecases.base.Either
import com.minor.mvvm_clean_architecture.domain.usecases.exception.Failure
import com.minor.mvvm_clean_architecture.data.remote.exception_interceptor.RemoteExceptionInterceptor

class HomeRepositoryImpl(
    private val remoteExceptionInterceptor: RemoteExceptionInterceptor,
    private val userLocalEntityMapper: UserLocalEntityMapper,
    private val userDao: UserDao,
    private val userResponseLocalMapper: UserResponseLocalMapper,
    private val userService: UserService
) : HomeRepository {

    override suspend fun getTopUsers(): Either<Failure, List<UserEntity>> =
        Either.runSuspendWithCatchError(errorInterceptors = listOf(remoteExceptionInterceptor)) {
            val dbResult = userLocalEntityMapper.mapList(userDao.getTopUsers())
            if (dbResult.isNullOrEmpty()) {
                val response = userService.fetchTopUsersAsync()
                val userDBOs = userResponseLocalMapper.mapList(response.items)
                userDao.insertUses(userDBOs)
                val dbAfterInsert = userLocalEntityMapper.mapList(userDao.getTopUsers())
                return@runSuspendWithCatchError Either.Success(dbAfterInsert)
            } else {
                return@runSuspendWithCatchError Either.Success(dbResult)
            }
        }

}