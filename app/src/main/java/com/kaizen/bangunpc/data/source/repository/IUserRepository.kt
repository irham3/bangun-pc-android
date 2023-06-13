package com.kaizen.bangunpc.data.source.repository

import io.github.jan.supabase.gotrue.user.UserSession

interface IUserRepository {
    fun getCurrentSession() : UserSession?
    suspend fun signUpWithEmail(email: String, password: String)
    suspend fun loginWithGoogle()
}