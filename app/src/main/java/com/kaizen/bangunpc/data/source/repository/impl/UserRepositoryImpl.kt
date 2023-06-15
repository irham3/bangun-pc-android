package com.kaizen.bangunpc.data.source.repository.impl

import com.kaizen.bangunpc.data.source.remote.dataresource.UserRDS
import com.kaizen.bangunpc.data.source.remote.dto.UserDto
import com.kaizen.bangunpc.data.source.repository.UserRepository
import com.kaizen.bangunpc.utils.SupabaseTables
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.gotrue.user.UserSession
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val userRDS: UserRDS,
    private val auth: GoTrue,
    private val postgrest: Postgrest
) : UserRepository {
    override fun getCurrentSession() : Flow<UserSession?> =
        flow {
            emit(auth.currentSessionOrNull())
        }

    override suspend fun getUserData(userSession: UserSession) : Flow<UserDto> =
        flow {
            val result = postgrest[SupabaseTables.users]
                .select {
                    eq("email", userSession.user?.email.toString())
                }
            val userData = result.decodeSingle<UserDto>()
            emit(userData)
        }.flowOn(Dispatchers.IO)

    override suspend fun createUserAccount(email: String, password: String, fullname: String): Boolean {
        return try {
            auth.signUpWith(Email) {
                this.email = email
                this.password = password
            }
            val userDto = UserDto(
                email = email,
                fullname = fullname
            )
            postgrest[SupabaseTables.users].insert(value = userDto, upsert = true)
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun loginWithEmail(email: String, password: String) : Boolean {
        return try {
            auth.loginWith(Email) {
                this.email = email
                this.password = password
            }
            true
        } catch (e: Exception) {
            false
        }

    }

    override suspend fun loginWithGoogle() {
        userRDS.loginWithGoogle()
    }

    override suspend fun logout(): Boolean {
        return try {
            auth.invalidateSession()
            true
        } catch (e: Exception) {
            false
        }
    }
}