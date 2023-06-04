package com.kaizen.bangunpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.kaizen.bangunpc.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        getSupabaseData()
        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BangunPCApp()
                }
            }
        }
    }

    // Testing to fetch supabase data
//    private fun getSupabaseData() {
//        lifecycleScope.launch {
//            val client = SupabaseUtil.getSupabaseClient()
//            val supabaseResponse = client.postgrest["gxcomp"].select()
//
//            // Mapping supabase response to Component data class
//            val data = supabaseResponse.decodeList<ComponentResult>()
//            Log.d("supabase", data.toString())
//        }
//    }
}

