package com.kaizen.bangunpc.data.source.remote

import com.kaizen.bangunpc.data.source.remote.network.ApiResult
import com.kaizen.bangunpc.data.source.remote.result.Component
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val supabaseClient: SupabaseClient
){
    suspend fun getAllComponents() : Flow<ApiResult<List<Component>>> =
        flow {
            try {
                val result = supabaseClient.postgrest["gxcomp"].select()
                val dataList = result.decodeList<Component>()
                if (dataList.isNotEmpty())
                    emit(ApiResult.Success(dataList))
                else
                    emit(ApiResult.Empty)
            } catch (e : Exception) {
                emit(ApiResult.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
}