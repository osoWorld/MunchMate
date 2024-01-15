package com.example.munchmate.registration.Classes.authViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.munchmate.registration.Classes.authRepo.AuthRepo
import com.example.munchmate.registration.Classes.authViewModel.AuthViewModel

class AuthViewModelFactory(private val authRepo: AuthRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthViewModel(authRepo) as T
    }
}