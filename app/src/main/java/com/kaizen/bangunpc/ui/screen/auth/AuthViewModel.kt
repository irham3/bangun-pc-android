package com.kaizen.bangunpc.ui.screen.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaizen.bangunpc.data.source.repository.impl.UserRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: UserRepositoryImpl
): ViewModel() {
    fun loginWithEmail(email: String, password: String, fullname: String) {
        viewModelScope.launch {
            if(repository.createAccount(email, password, fullname)){
                Log.d("Auth", "Success")
            } else  Log.e("Auth", "Failed")
        }
    }

    fun loginWithGoogle() {
        viewModelScope.launch {
            repository.loginWithGoogle()
        }
    }

    fun getCurrentUserSession() =
        repository.getCurrentSession()
}