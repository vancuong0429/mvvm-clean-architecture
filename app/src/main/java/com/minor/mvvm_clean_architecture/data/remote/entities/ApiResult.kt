package com.minor.mvvm_clean_architecture.data.remote.entities

import com.google.gson.annotations.SerializedName

data class ApiResult<T>(@SerializedName("total_count") val totalCount: Int, @SerializedName("items") val items: List<T>)