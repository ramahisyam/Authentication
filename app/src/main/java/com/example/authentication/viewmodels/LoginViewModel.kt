package com.example.authentication.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.authentication.utils.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel() : ViewModel() {

    private val _status = MutableLiveData<Int>()

    private val viewModelScope = CoroutineScope(Dispatchers.IO)
    private val retrofitClient = RetrofitClient.instance

    val status: LiveData<Int> = _status

    fun login(username: String, password: String){
        val authService = retrofitClient.apiService

        viewModelScope.launch{
            val loginResponse = authService.login(username, password)

            Log.d("Login Form", "onCreate: $username")
            Log.d("Login Form", "onCreate: $password")
            Log.d("Retrofit", "login: $retrofitClient $loginResponse")

            if (loginResponse.isSuccessful) {
                Log.d("View Model", "login: ${loginResponse.body()}")
            } else{
                // Handle the login error.
                Log.d("View Model error", "login: ${loginResponse.code()}")
            }
            withContext(Dispatchers.Main) {
                _status.value = loginResponse.code()
            }
        }
    }
}