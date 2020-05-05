package com.minor.mvvm_clean_architecture.domain.di

import com.minor.mvvm_clean_architecture.domain.common.AppDispatchers
import com.minor.mvvm_clean_architecture.domain.usecases.GetTopUsersUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val createDomainModule = module {

    factory { GetTopUsersUseCase(homeRepository = get()) }

    single { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }
}