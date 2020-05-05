package com.minor.mvvm_clean_architecture.data.repository.di

import com.minor.mvvm_clean_architecture.domain.repositories.HomeRepository
import com.minor.mvvm_clean_architecture.data.repository.HomeRepositoryImpl
import com.minor.mvvm_clean_architecture.data.repository.mapper.UserLocalEntityMapper
import com.minor.mvvm_clean_architecture.data.repository.mapper.UserRemoteEntityMapper
import com.minor.mvvm_clean_architecture.data.repository.mapper.UserResponseLocalMapper
import org.koin.dsl.module

val createRepositoryModule = module {

    factory {
        UserRemoteEntityMapper()
    }

    factory {
        UserResponseLocalMapper()
    }

    factory {
        UserLocalEntityMapper()
    }

    factory<HomeRepository> {
        HomeRepositoryImpl(
            userDao = get(),
            remoteExceptionInterceptor = get(),
            userLocalEntityMapper = get(),
            userResponseLocalMapper = get(),
            userService = get()
        )
    }
}