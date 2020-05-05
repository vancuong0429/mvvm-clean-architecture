package com.minor.mvvm_clean_architecture.domain.entities

import java.util.*

data class UserEntity(
    val id: String,

    val login: String,

    val avatarUrl: String,

    val name: String,

    val company: String,

    val blog: String,

    val lastRefreshed: Date
)