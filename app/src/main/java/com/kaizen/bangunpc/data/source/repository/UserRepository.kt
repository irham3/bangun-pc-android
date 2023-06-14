package com.kaizen.bangunpc.data.source.repository

import io.github.jan.supabase.gotrue.user.UserSession

interface UserRepository {
    fun getCurrentSession() : UserSession?
    suspend fun createAccount(email: String, password: String, fullname: String) : Boolean
    suspend fun loginWithGoogle()
}