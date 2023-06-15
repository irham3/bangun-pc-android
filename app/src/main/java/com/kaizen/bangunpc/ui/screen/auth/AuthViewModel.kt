package com.kaizen.bangunpc.ui.screen.auth

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaizen.bangunpc.data.source.repository.impl.UserRepositoryImpl
import com.kaizen.bangunpc.ui.common.MessageState
import dagger.hilt.android.lifecycle.HiltViewModel
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

    private val _toastMessage: MutableStateFlow<MessageState<String>> = MutableStateFlow(MessageState.Loading)
    val toastMessageState = _toastMessage.asStateFlow()

    private val _isAuth = mutableStateOf(false)
    val isAuth: State<Boolean>
        get() = _isAuth

    private val _userSession = MutableStateFlow(AuthUiState.UserSession())
    val userSession = _userSession.asStateFlow()

    init {
        viewModelScope.launch {
            loadUserSession()
        }
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

    private suspend fun loadUserSession() {
        repository.getCurrentSession()
            .collect{
                _userSession.value = AuthUiState.UserSession(it)
            }
    }


    fun loginWithEmail(email: String, password: String) {
        viewModelScope.launch {
            _isLoading.value = true
            if (email.isEmpty()) _toastMessage.value = MessageState.Warning("Email masih kosong")
            if (password.isEmpty()) _toastMessage.value = MessageState.Warning("Password masih kosong")
            if(repository.loginWithEmail(email, password)) {
                _isLoading.value = false
                _isAuth.value = true
                _toastMessage.value = MessageState.Success("Berhasil masuk")
            } else{
                _toastMessage.value = MessageState.Error("Email atau password salah")
                _isAuth.value = false
                _isLoading.value = false
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            _isLoading.value = true
            Log.d("Auth", "isLoading before logout = $isLoading")
            if(repository.logout()) {
                _isLoading.value = false
                _isAuth.value = true
                Log.d("Auth", "isLoading in logout = $isLoading")
            } else{
                _isAuth.value = false
                _isLoading.value = false
                Log.d("Auth", "isLoading after logout = $isLoading")
            }
        }
    }
}