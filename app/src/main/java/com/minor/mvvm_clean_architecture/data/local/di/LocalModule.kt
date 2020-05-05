package com.minor.mvvm_clean_architecture.data.local.di

import com.minor.mvvm_clean_architecture.data.local.MulAppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {
    single { MulAppDatabase.buildDatabase(androidContext()) }
    factory { get<MulAppDatabase>().userDao() }
}