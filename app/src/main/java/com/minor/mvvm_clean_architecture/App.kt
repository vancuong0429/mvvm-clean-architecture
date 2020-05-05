package com.minor.mvvm_clean_architecture

import android.app.Application
import com.minor.mvvm_clean_architecture.data.remote.di.createRemoteModule
import com.minor.mvvm_clean_architecture.data.repository.di.createRepositoryModule
import com.minor.mvvm_clean_architecture.domain.di.createDomainModule
import com.minor.mvvm_clean_architecture.ui.di.createHomeModule
import com.minor.mvvm_clean_architecture.data.local.di.localModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class App : Application() {
    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    // PUBLIC API ---
    open fun provideComponent() = appComponent

    // CONFIGURATION ---
    open fun configureDi() =
        startKoin {
            androidContext(this@App)
            modules(provideComponent())
        }


}

val appComponent = listOf(
    createRemoteModule("https://api.github.com/"),
    createDomainModule,
    createRepositoryModule,
    createHomeModule,
    localModule
)