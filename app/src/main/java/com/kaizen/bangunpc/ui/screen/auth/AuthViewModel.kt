package com.kaizen.bangunpc.ui.screen.auth

import androidx.lifecycle.ViewModel
import com.kaizen.bangunpc.data.source.repository.impl.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: UserRepository
): ViewModel() {
    suspend fun loginWithGoogle() {
        repository.loginWithGoogle()
    }

    fun getCurrentUserSession() =
        repository.getCurrentSession()
}