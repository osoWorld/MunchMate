package com.example.munchmate.utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

object AuthObj {
    val auth = FirebaseAuth.getInstance()
    val database = FirebaseDatabase.getInstance()
}