package com.example.munchmate.registration.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.munchmate.MainActivity
import com.example.munchmate.databinding.ActivityStartScreenBinding
import com.example.munchmate.registration.Classes.authRepo.AuthRepo
import com.example.munchmate.registration.Classes.authViewModel.AuthViewModel
import com.example.munchmate.registration.Classes.authViewModelFactory.AuthViewModelFactory

class StartScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartScreenBinding
    private lateinit var authViewModel: AuthViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val authRepo = AuthRepo()
        val authViewModelFactory = AuthViewModelFactory(authRepo)
        authViewModel = ViewModelProvider(this,authViewModelFactory)[AuthViewModel::class.java]

        authViewModel.already()
        authViewModel.already.observe(this){already ->
            if (already){
                startActivity(Intent(this, MainActivity::class.java))
            }
        }

        binding.nextButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}