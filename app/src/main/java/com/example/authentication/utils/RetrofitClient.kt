package com.example.authentication.utils

import com.example.authentication.repositories.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor(){
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)

    companion object {
        val instance: RetrofitClient by lazy { RetrofitClient() }
    }
}