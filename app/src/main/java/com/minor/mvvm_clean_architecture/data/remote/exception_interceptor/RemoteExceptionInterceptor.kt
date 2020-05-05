package com.minor.mvvm_clean_architecture.data.remote.exception_interceptor

import com.minor.mvvm_clean_architecture.domain.usecases.exception.Failure
import com.minor.mvvm_clean_architecture.domain.usecases.exception.ExceptionInterceptor
import retrofit2.HttpException

class RemoteExceptionInterceptor : ExceptionInterceptor {
    override fun handleException(exception: Exception): Failure? {
        return when (exception) {
            is HttpException -> {
                val errorMsg = if (exception.message() != null) {
                    exception.message()
                } else {
                    ""
                }
                Failure.ApiError(exception.code(), errorMsg)
            }
            else -> null
        }
    }
}