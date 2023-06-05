package com.kaizen.bangunpc.data.source.remote.dataresource

import com.kaizen.bangunpc.data.source.remote.network.ApiResult
import com.kaizen.bangunpc.data.source.remote.result.ComponentResult
import com.kaizen.bangunpc.data.source.remote.result.PCBuildResult
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import io.github.jan.supabase.postgrest.query.Order
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject

class ProductRDS @Inject constructor(
    private val supabaseClient: SupabaseClient
){
//    suspend fun getAllComponents() : Flow<ApiResult<List<ComponentResult>>> =
//        flow {
//            try {
//                val result = supabaseClient.postgrest["gxcomp"].select {
//                    order("id", Order.ASCENDING)
//                }
//                val dataList = result.decodeList<ComponentResult>()
//                if (dataList.isNotEmpty())
//                    emit(ApiResult.Success(dataList))
//                else
//                    emit(ApiResult.Loading)
//            } catch (e : Exception) {
//                emit(ApiResult.Error(e.toString()))
//            }
//        }.flowOn(Dispatchers.IO)

    suspend fun getAllCPUs() : Flow<ApiResult<List<ComponentResult>>> =
        flow {
            try {
                val result = supabaseClient.postgrest["cpus"]
                    .select(
                        columns = Columns.raw("gxcomp(*)")
                    ) {
                        order("id", Order.ASCENDING)
                    }
                val dataList = result.decodeList<ComponentResult>()
                if (dataList.isNotEmpty())
                    emit(ApiResult.Success(dataList))
                else
                    emit(ApiResult.Loading)
            } catch (e : Exception) {
                emit(ApiResult.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)

    suspend fun getAllGPUs() : Flow<ApiResult<List<ComponentResult>>> =
        flow {
            try {
                val result = supabaseClient.postgrest["gpus"]
                    .select(
                        columns = Columns.raw("gxcomp(*)")
                    ) {
                        order("id", Order.ASCENDING)
                    }
                val dataList = result.decodeList<ComponentResult>()
                if (dataList.isNotEmpty())
                    emit(ApiResult.Success(dataList))
                else
                    emit(ApiResult.Loading)
            } catch (e : Exception) {
                emit(ApiResult.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)

    suspend fun getAllCasings() : Flow<ApiResult<List<ComponentResult>>> =
        flow {
            try {
                val result = supabaseClient.postgrest["cases"]
                    .select(
                        columns = Columns.raw("gxcomp(*)")
                    ) {
                        order("id", Order.ASCENDING)
                    }
                val dataList = result.decodeList<ComponentResult>()
                if (dataList.isNotEmpty())
                    emit(ApiResult.Success(dataList))
                else
                    emit(ApiResult.Loading)
            } catch (e : Exception) {
                emit(ApiResult.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)

    suspend fun getAllMemories() : Flow<ApiResult<List<ComponentResult>>> =
        flow {
            try {
                val result = supabaseClient.postgrest["memories"]
                    .select(
                        columns = Columns.raw("gxcomp(*)")
                    ) {
                        order("id", Order.ASCENDING)
                    }
                val dataList = result.decodeList<ComponentResult>()
                if (dataList.isNotEmpty())
                    emit(ApiResult.Success(dataList))
                else
                    emit(ApiResult.Loading)
            } catch (e : Exception) {
                emit(ApiResult.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)

    suspend fun getAllMotherboards() : Flow<ApiResult<List<ComponentResult>>> =
        flow {
            try {
                val result = supabaseClient.postgrest["motherboards"]
                    .select(
                        columns = Columns.raw("gxcomp(*)")
                    ) {
                        order("id", Order.ASCENDING)
                    }
                val dataList = result.decodeList<ComponentResult>()
                if (dataList.isNotEmpty())
                    emit(ApiResult.Success(dataList))
                else
                    emit(ApiResult.Loading)
            } catch (e : Exception) {
                emit(ApiResult.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)

    suspend fun getAllPSUs() : Flow<ApiResult<List<ComponentResult>>> =
        flow {
            try {
                val result = supabaseClient.postgrest["power_supplies"]
                    .select(
                        columns = Columns.raw("gxcomp(*)")
                    ) {
                        order("id", Order.ASCENDING)
                    }
                val dataList = result.decodeList<ComponentResult>()
                if (dataList.isNotEmpty())
                    emit(ApiResult.Success(dataList))
                else
                    emit(ApiResult.Loading)
            } catch (e : Exception) {
                emit(ApiResult.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)

    suspend fun getAllStorages() : Flow<ApiResult<List<ComponentResult>>> =
        flow {
            try {
                val result = supabaseClient.postgrest["storages"]
                    .select(
                        columns = Columns.raw("gxcomp(*)")
                    ) {
                        order("id", Order.ASCENDING)
                    }
                val dataList = result.decodeList<ComponentResult>()
                if (dataList.isNotEmpty())
                    emit(ApiResult.Success(dataList))
                else
                    emit(ApiResult.Loading)
            } catch (e : Exception) {
                emit(ApiResult.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)

    suspend fun getAllIntelPCs() : Flow<ApiResult<List<PCBuildResult>>> =
        flow {
            try {
                val result = supabaseClient.postgrest["pc_builds"].select {
                    eq("category", 2)
                    order("id", Order.ASCENDING)
                }
                val dataList = result.decodeList<PCBuildResult>()
                if (dataList.isNotEmpty())
                    emit(ApiResult.Success(dataList))
                else
                    emit(ApiResult.Loading)
            } catch (e : Exception) {
                emit(ApiResult.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)

    suspend fun getAllAMDPCs() : Flow<ApiResult<List<PCBuildResult>>> =
        flow {
            try {
                val result = supabaseClient.postgrest["pc_builds"].select {
                    eq("category", 1)
                    order("id", Order.ASCENDING)
                }
                val dataList = result.decodeList<PCBuildResult>()
                if (dataList.isNotEmpty())
                    emit(ApiResult.Success(dataList))
                else
                    emit(ApiResult.Loading)
            } catch (e : Exception) {
                emit(ApiResult.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
}