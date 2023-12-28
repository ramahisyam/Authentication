package com.example.authentication.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.authentication.R
import com.example.authentication.databinding.ActivityLoginBinding
import com.example.authentication.viewmodels.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private val loginViewModel by viewModels<LoginViewModel>()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        binding.button.setOnClickListener {

            loginViewModel.login(
                binding.editTextTextEmailAddress.text.toString(),
                binding.editTextTextPassword.text.toString()
            )
            loginViewModel.status.observe(this) {
                if (it == 200){
                    Toast.makeText(this@LoginActivity, "Success", Toast.LENGTH_SHORT).show()
                } else if (it == 400) {
                    Toast.makeText(this@LoginActivity, "Invalid Credential", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}