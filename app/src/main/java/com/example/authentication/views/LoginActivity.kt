package com.example.authentication.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.authentication.R
import com.example.authentication.databinding.ActivityLoginBinding
import com.example.authentication.viewmodels.LoginViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel by viewModels<LoginViewModel>()
    private val viewModelScope = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("TAG", "onCreate: LoginActivity")
        loginViewModel.status.observe(this) { status ->
            when (status) {
                200 -> startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                400 -> Toast.makeText(this@LoginActivity, "User Not Found", Toast.LENGTH_SHORT).show()
                // Tambahkan kasus lain jika diperlukan
            }
        }

        binding.button.setOnClickListener {
            loginViewModel.login(
                binding.editTextTextEmailAddress.text.toString(),
                binding.editTextTextPassword.text.toString()
            )
        }
    }
}