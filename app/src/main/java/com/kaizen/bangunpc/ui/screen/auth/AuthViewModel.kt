package com.kaizen.bangunpc.ui.screen.auth

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaizen.bangunpc.data.source.repository.impl.UserRepositoryImpl
import com.kaizen.bangunpc.ui.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.jan.supabase.gotrue.user.UserSession
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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

    private val _userSession = MutableStateFlow(AuthUiState.UserSession())
    val userSession = _userSession.asStateFlow()

    init {
        loadUserSession()
    }

    fun createUserAccount(email: String, password: String, fullname: String) {
        viewModelScope.launch {
            _isLoading.value = true
            if(repository.createUserAccount(email, password, fullname)) {
                _isLoading.value = false
                _isAuth.value = true
                loginWithEmail(email,password)
                Log.d("Auth", "Success")
            } else{
                _isAuth.value = false
                _isLoading.value = false
            }
        }
    }

    private fun loadUserSession() {
        repository.getCurrentSession().let {
            _userSession.value = AuthUiState.UserSession(it)
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
        }
    }

    fun loginWithGoogle() {
        viewModelScope.launch {
            repository.loginWithGoogle()
        }
    }

    fun logout() {
        _isLoading.value = true
        viewModelScope.launch {
            if(repository.logout()) {
                _isLoading.value = false
                _isAuth.value = true
            } else{
                _isAuth.value = false
                _isLoading.value = false
            }
        }
    }
}