package com.example.munchmate.registration.Classes.authRepo

import android.util.Log
import com.example.munchmate.API.FirebaseAuth
import com.example.munchmate.registration.Classes.authDataClass.AuthData
import com.example.munchmate.utils.AuthObj
import com.example.munchmate.utils.TAGS
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class AuthRepo : FirebaseAuth {
//    var totalUser = 0L
//
//    init {
//        AuthObj.database.reference.child("Users").addListenerForSingleValueEvent(object : ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                totalUser = snapshot.childrenCount
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//
//        })
//    }
    override suspend fun signupWithEmail(email: String, password: String): Task<AuthResult> {
        return AuthObj.auth.createUserWithEmailAndPassword(email, password)

    }

    override suspend fun loginWithEmail(email: String, password: String): Task<AuthResult> {
        return AuthObj.auth.signInWithEmailAndPassword(email, password)
    }

    override suspend fun registerDatabase(data: AuthData): Task<Void> {
        return AuthObj.database.reference.child("Users").child(AuthObj.auth.currentUser!!.uid)
            .setValue(data)
    }
}