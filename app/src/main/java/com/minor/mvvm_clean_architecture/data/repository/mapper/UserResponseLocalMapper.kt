package com.minor.mvvm_clean_architecture.data.repository.mapper

import com.minor.mvvm_clean_architecture.domain.common.Mapper
import com.minor.mvvm_clean_architecture.data.local.entities.UserDBO
import com.minor.mvvm_clean_architecture.data.remote.entities.UserResponse
import java.util.*

class UserResponseLocalMapper : Mapper<UserResponse, UserDBO>() {
    override fun map(input: UserResponse): UserDBO = UserDBO(
        id = input.id.toString(),
        login = input.login.toString(),
        avatarUrl = input.avatarUrl.toString(),
        name = input.name,
        company = input.company,
        blog = input.blog,
        lastRefreshed = Date()
    )
}