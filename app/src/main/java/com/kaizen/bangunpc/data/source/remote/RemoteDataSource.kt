package com.kaizen.bangunpc.data.source.remote

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val supabaseClient: SupabaseClient
){
    suspend fun getAllComponents() {
        supabaseClient.postgrest["gxcomp"].select()
    }
}