package com.minor.mvvm_clean_architecture.data.repository.mapper


import com.minor.mvvm_clean_architecture.domain.common.Mapper
import com.minor.mvvm_clean_architecture.domain.entities.UserEntity
import com.minor.mvvm_clean_architecture.data.remote.entities.UserResponse
import java.util.*

class UserRemoteEntityMapper : Mapper<UserResponse, UserEntity>() {
    override fun map(input: UserResponse): UserEntity = UserEntity(
        id = input.id.toString(),
        login = input.login.toString(),
        avatarUrl = input.avatarUrl.toString(),
        name = input.name.toString(),
        company = input.company.toString(),
        blog = input.blog.toString(),
        lastRefreshed = Date()
    )
}