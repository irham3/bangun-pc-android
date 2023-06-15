package com.kaizen.bangunpc.ui.screen.auth

interface AuthUiState {
    val error: String

    data class UserSession(
        val data: io.github.jan.supabase.gotrue.user.UserSession? = null,
        override val error: String = "Undefined error"
    ) : AuthUiState

}