package com.example.authentication.models

import com.google.gson.annotations.SerializedName
import retrofit2.http.Field

data class UserResponse (
    @SerializedName("page") val page: Int,
    @SerializedName("per_page") val perPage: Int,
    @SerializedName("total") val total: Int,
    @SerializedName("total_page") val totalPage: Int,
    @SerializedName("data") val data: List<User>
)