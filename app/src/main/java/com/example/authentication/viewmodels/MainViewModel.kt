package com.example.authentication.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.authentication.models.UserResponse
import com.example.authentication.utils.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {
    private val retrofitClient = RetrofitClient.instance
    private val viewModelScope = CoroutineScope(Dispatchers.IO)

    private val _userResponse = MutableLiveData<UserResponse>()
    val userResponse: LiveData<UserResponse> get() = _userResponse

    fun getUsers(page: Int){
        val userService = retrofitClient.apiService

        viewModelScope.launch{
            try {
                val userResponse = userService.getUsers(page)

                if (userResponse.isSuccessful) {
                    _userResponse.postValue(userResponse.body())
                } else {
                    // Handle the error, for now, just log it
                    Log.d("View Model error", "main: ${userResponse.code()}")
                }
            } catch (e: Exception) {
                // Handle network or other exceptions
                Log.e("View Model error", "Error fetching users", e)
            }
        }
    }
}