package com.example.authentication.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.authentication.R
import com.example.authentication.databinding.ActivityLoginBinding
import com.example.authentication.databinding.ActivityMainBinding
import com.example.authentication.viewmodels.LoginViewModel
import com.example.authentication.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("TAG", "onCreate: MainActivity")
        mainViewModel.getUsers(1)
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = UserAdapter(emptyList())
        recyclerView.adapter = adapter
        mainViewModel.userResponse.observe(this) { userResponse ->
            // Update the RecyclerView adapter when data changes

            adapter.updateData(userResponse.data)
        }

        binding.buttonPage1.setOnClickListener {
            mainViewModel.getUsers(1)
        }

        binding.buttonPage2.setOnClickListener {
            mainViewModel.getUsers(2)
        }
    }
}