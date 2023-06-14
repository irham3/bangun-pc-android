package com.kaizen.bangunpc.ui.screen.auth

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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
    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean>
        get() = _isLoading

    private val _isAuth = mutableStateOf(false)
    val isAuth: State<Boolean>
        get() = _isAuth
    fun createUserAccount(email: String, password: String, fullname: String) {
        viewModelScope.launch {
            _isLoading.value = true
            if(repository.createUserAccount(email, password, fullname)) {
                _isLoading.value = false
                _isAuth.value = true
                Log.d("Auth", "Success")
            } else{
                _isAuth.value = false
                _isLoading.value = false
            }
        }
    }

    fun loginWithEmail(email: String, password: String) {
        viewModelScope.launch {
            _isLoading.value = true
            if(repository.loginWithEmail(email, password)) {
                _isLoading.value = false
                _isAuth.value = true
                Log.d("Auth", "Success")
            } else{
                _isAuth.value = false
                _isLoading.value = false
            }

            Log.d("Auth", repository.getCurrentSession().toString())
        }
    }

    fun loginWithGoogle() {
        viewModelScope.launch {
            repository.loginWithGoogle()
        }
    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }

    fun getCurrentUserSession() =
        repository.getCurrentSession()
}