package com.kaizen.bangunpc.ui.screen.auth

import com.kaizen.bangunpc.data.source.remote.dto.UserDto

interface AuthUiState {
    val error: String

    data class UserSession(
        val data: io.github.jan.supabase.gotrue.user.UserSession? = null,
        override val error: String = "Undefined error"
    ) : AuthUiState

    data class UserData(
        val data: UserDto? = null,
        override val error: String = "Undefined error"
    ) : AuthUiState

}