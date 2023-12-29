package com.example.authentication.repositories

import com.example.authentication.models.LoginResponse
import com.example.authentication.models.User
import com.example.authentication.models.UserResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @FormUrlEncoded
    @POST("/api/login")
    suspend fun login(@Field("email") username: String, @Field("password") password: String): Response<LoginResponse>

    @GET("/api/users")
    suspend fun getUsers(@Query("page") page: Int): Response<UserResponse>
}