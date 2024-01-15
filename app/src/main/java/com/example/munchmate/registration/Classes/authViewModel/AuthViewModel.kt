package com.example.munchmate.registration.Classes.authViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.munchmate.registration.Classes.authRepo.AuthRepo
import com.example.munchmate.registration.Classes.authDataClass.AuthData
import com.example.munchmate.utils.AuthObj
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthViewModel(private val authRepo: AuthRepo) : ViewModel() {

    private val _result = MutableLiveData<Boolean>(false)
    val result: LiveData<Boolean>
        get() = _result

    private val _progressBar = MutableLiveData<Boolean>(false)
    val progressBar: LiveData<Boolean>
        get() = _progressBar

    private val _message = MutableLiveData<String>()
    val message: LiveData<String>
        get() = _message

    private var _register = false
    var getUID = ""

    private val _uid = MutableLiveData<Boolean>(false)
    val uid: LiveData<Boolean>
        get() = _uid

//    val uid: LiveData<String>
//        get() = _uid

    private val _already = MutableLiveData<Boolean>(false)
    val already: LiveData<Boolean>
        get() = _already

    private val _bye = MutableLiveData<Boolean>(false)
    val bye : LiveData<Boolean>
        get() = _bye

    fun already(){
        viewModelScope.launch(Dispatchers.IO) {
            if (AuthObj.auth.currentUser!!.uid != null){
                _already.postValue(true)
            }
            else{
                _already.postValue(false)
            }
        }
    }

    fun byeBye(){
        AuthObj.auth.signOut()
        _bye.postValue(true)
    }

    fun login(email: String, password: String) {
        _progressBar.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            authRepo.loginWithEmail(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    _result.postValue(true)
                    _progressBar.postValue(false)
                    _message.postValue("Welcome Again")
                }
            }.addOnFailureListener {
                _progressBar.postValue(false)
                _message.postValue("Auth : ${it.message}")
                _result.postValue(false)
            }
        }
    }

    fun signup(email: String, password: String, data: AuthData) {
        _progressBar.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            authRepo.signupWithEmail(email, password).addOnCompleteListener {
                if (it.isSuccessful) {

                    // Registering User to Firebase
                    _register = true
                    _uid.postValue(true)

                    if (_register) {
                        save(data)

                    }
                }
            }.addOnFailureListener {
                _progressBar.postValue(false)
                _message.postValue("Auth : ${it.message}")
                _result.postValue(false)
            }
        }
    }

    private fun save(data: AuthData) {
        viewModelScope.launch(Dispatchers.IO) {
            authRepo.registerDatabase(data).addOnSuccessListener {
                _result.postValue(true)
                _progressBar.postValue(false)
                _message.postValue("Welcome")
                getUID = AuthObj.auth.currentUser!!.uid

//                if (!data.uid.isNullOrEmpty()) {
//                    getUID = data.uid
//                }

            }.addOnFailureListener { e ->
                _message.postValue("Database : ${e.message}")
            }
        }
    }
}