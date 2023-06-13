package com.kaizen.bangunpc.data.source.repository.impl

import com.kaizen.bangunpc.data.source.remote.dataresource.UserRDS
import com.kaizen.bangunpc.data.source.repository.IUserRepository
import io.github.jan.supabase.gotrue.user.UserSession
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val userRDS: UserRDS
) : IUserRepository {
    override fun getCurrentSession(): UserSession? =
        userRDS.getCurrentSession()


    override suspend fun signUpWithEmail(email: String, password: String) {
        userRDS.signUpWithEmail(email, password)
    }

    override suspend fun loginWithGoogle() {
        userRDS.loginWithGoogle()
    }
}