package com.example.munchmate.registration.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.munchmate.databinding.ActivitySignupBinding
import com.example.munchmate.registration.Classes.authRepo.AuthRepo
import com.example.munchmate.registration.Classes.authDataClass.AuthData
import com.example.munchmate.utils.TAGS
import com.example.munchmate.registration.Classes.authViewModel.AuthViewModel
import com.example.munchmate.registration.Classes.authViewModelFactory.AuthViewModelFactory

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val authRepo = AuthRepo()
        val authViewModelFactory = AuthViewModelFactory(authRepo)
        authViewModel = ViewModelProvider(this, authViewModelFactory)[AuthViewModel::class.java]

        authViewModel.progressBar.observe(this) { progress ->
            if (progress) {
                binding.signupEmail.isEnabled = false
                binding.signupPassword.isEnabled = false
                binding.progressCircularSignup.visibility = View.VISIBLE
            } else {
                binding.signupEmail.isEnabled = true
                binding.signupPassword.isEnabled = true
                binding.progressCircularSignup.visibility = View.GONE
            }
        }
        authViewModel.message.observe(this) { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        binding.loginTextView.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
        binding.createAccountButton.setOnClickListener {
            val data = AuthData(
                binding.signupName.text.toString().trim(),
                binding.signupEmail.text.toString().trim(),
                binding.signupPassword.text.toString().trim(),
//                authViewModel.getUID
            )
            authViewModel.signup(
                binding.signupEmail.text.toString().trim(),
                binding.signupPassword.text.toString().trim(),
                data
            )
            Log.d(TAGS, data.email)
            authViewModel.result.observe(this) { go ->
                if (go) {
                    startActivity(Intent(this, LoginActivity::class.java))
                }
            }
        }
    }
}