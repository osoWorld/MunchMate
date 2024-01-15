package com.example.munchmate.API

import com.example.munchmate.registration.Classes.authDataClass.AuthData
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface FirebaseAuth {
    suspend fun signupWithEmail(email: String,password: String) : Task<AuthResult>
    suspend fun loginWithEmail(email: String,password: String): Task<AuthResult>
    suspend fun registerDatabase(data: AuthData): Task<Void>
}