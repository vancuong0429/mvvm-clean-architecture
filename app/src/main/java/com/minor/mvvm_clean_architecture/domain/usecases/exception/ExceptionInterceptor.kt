package com.minor.mvvm_clean_architecture.domain.usecases.exception

interface ExceptionInterceptor {
    fun handleException(exception: Exception): Failure?
}