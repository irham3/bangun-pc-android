package com.kaizen.bangunpc.utils

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import com.kaizen.bangunpc.BuildConfig
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.GoTrue

object SupabaseUtil {
    fun getSupabaseClient() : SupabaseClient{
        return createSupabaseClient(
            supabaseUrl = BuildConfig.SUPABASE_URL,
            supabaseKey = BuildConfig.SUPABASE_KEY
        ) {
            install(GoTrue)
            install(Postgrest)
        }
    }
}