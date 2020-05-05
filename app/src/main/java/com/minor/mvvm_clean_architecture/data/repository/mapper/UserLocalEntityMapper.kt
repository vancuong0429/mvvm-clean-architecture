package com.minor.mvvm_clean_architecture.data.repository.mapper

import com.minor.mvvm_clean_architecture.domain.common.Mapper
import com.minor.mvvm_clean_architecture.domain.entities.UserEntity
import com.minor.mvvm_clean_architecture.data.local.entities.UserDBO


class UserLocalEntityMapper : Mapper<UserDBO, UserEntity>() {
    override fun map(input: UserDBO): UserEntity = UserEntity(
        id = input.id,
        login = input.login,
        avatarUrl = input.avatarUrl,
        name = input.name.toString(),
        company = input.company.toString(),
        blog = input.blog.toString(),
        lastRefreshed = input.lastRefreshed
    )
}