package com.example.munchmate.registration.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.munchmate.MainActivity
import com.example.munchmate.databinding.ActivityLoginBinding
import com.example.munchmate.registration.Classes.authRepo.AuthRepo
import com.example.munchmate.registration.Classes.authViewModel.AuthViewModel
import com.example.munchmate.registration.Classes.authViewModelFactory.AuthViewModelFactory

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var authViewModel: AuthViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val authRepo = AuthRepo()
        val authViewModelFactory = AuthViewModelFactory(authRepo)
        authViewModel = ViewModelProvider(this, authViewModelFactory)[AuthViewModel::class.java]

        authViewModel.progressBar.observe(this) { progress ->
            if (progress) {
                binding.loginEmail.isEnabled = false
                binding.loginPassword.isEnabled = false
                binding.progressCircularLogin.visibility = View.VISIBLE
            } else {
                binding.loginEmail.isEnabled = true
                binding.loginPassword.isEnabled = true
                binding.progressCircularLogin.visibility = View.GONE
            }
        }

        authViewModel.message.observe(this) { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        binding.signUpTextView.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        binding.loginButton.setOnClickListener {
            authViewModel.login(
                binding.loginEmail.text.toString().trim(),
                binding.loginPassword.text.toString().trim()
            )

            authViewModel.result.observe(this) { result ->
                if (result) {
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
        }
    }
}