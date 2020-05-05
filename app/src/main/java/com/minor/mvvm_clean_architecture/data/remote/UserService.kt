package com.minor.mvvm_clean_architecture.data.remote

import com.minor.mvvm_clean_architecture.data.remote.entities.ApiResult
import com.minor.mvvm_clean_architecture.data.remote.entities.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface UserService {
    @GET("search/users")
    suspend fun fetchTopUsersAsync(
        @Query("q") query: String = "PhilippeB",
        @Query("sort") sort: String = "followers"
    ): ApiResult<UserResponse>

}