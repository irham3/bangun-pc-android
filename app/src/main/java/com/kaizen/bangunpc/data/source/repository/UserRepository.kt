package com.kaizen.bangunpc.data.source.repository

import com.kaizen.bangunpc.data.source.remote.dto.UserDto
import io.github.jan.supabase.gotrue.user.UserSession
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getCurrentSession() : Flow<UserSession?>
    suspend fun getUserData(userSession: UserSession) : Flow<UserDto>
    suspend fun createUserAccount(email: String, password: String, fullname: String) : Boolean
    suspend fun loginWithEmail(email: String, password: String) : Boolean
    suspend fun loginWithGoogle()
    suspend fun logout(): Boolean
}