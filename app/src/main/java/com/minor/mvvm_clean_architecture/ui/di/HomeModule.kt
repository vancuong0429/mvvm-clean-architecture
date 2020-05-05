package com.minor.mvvm_clean_architecture.ui.di


import com.minor.mvvm_clean_architecture.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val createHomeModule = module {

    viewModel { HomeViewModel(getTopUsersUseCase = get(), appDispatchers = get()) }

}