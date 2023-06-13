package com.kaizen.bangunpc.data.source.remote.dataresource

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.providers.Google
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.gotrue.user.UserSession
import javax.inject.Inject

class UserRDS @Inject constructor(
    private val supabaseClient: SupabaseClient
) {
    val goTrue = supabaseClient.gotrue
    fun getCurrentSession() : UserSession? {
        return supabaseClient.gotrue.currentSessionOrNull()
    }

    suspend fun signUpWithEmail(email: String, password: String) {
        goTrue.signUpWith(Email) {
            this.email = email
            this.password = password
        }
    }

    suspend fun loginWithGoogle() {
        supabaseClient.gotrue.loginWith(Google)
    }

    fun logout() {
        supabaseClient.gotrue
    }
}