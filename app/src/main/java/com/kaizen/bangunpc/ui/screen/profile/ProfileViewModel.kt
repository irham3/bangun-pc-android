package com.kaizen.bangunpc.ui.screen.profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaizen.bangunpc.data.source.repository.impl.UserRepositoryImpl
import com.kaizen.bangunpc.ui.screen.auth.AuthUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor (
    private val repository: UserRepositoryImpl
) : ViewModel() {

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean>
        get() = _isLoading

    private val _isAuth = mutableStateOf(false)
    val isAuth: State<Boolean>
        get() = _isAuth

    private val _userSession = MutableStateFlow(AuthUiState.UserSession())
    val userSession = _userSession.asStateFlow()

    private val _userData = MutableStateFlow(AuthUiState.UserData())
    val userData = _userData.asStateFlow()

    init {
        loadUserSession()
        if (_userSession.value.data != null) {
            loadUserData()
            _isAuth.value = true
        }
    }

    private fun loadUserSession() {
        viewModelScope.launch {
            repository.getCurrentSession()
                .collect {
                    _userSession.value = AuthUiState.UserSession(it)
                }
        }
    }

    private fun loadUserData() {
        viewModelScope.launch {
            repository.getUserData(_userSession.value.data!!)
                .collect {
                    _userData.value = AuthUiState.UserData(it)
                }
        }
    }

    fun logout() {
        viewModelScope.launch {
            _isLoading.value = true
            if(repository.logout()) {
                _isAuth.value = false
                _isLoading.value = false
            } else{
                _isLoading.value = false
            }
        }
    }
}