package com.kaizen.bangunpc.data.source.remote.dataresource

import com.kaizen.bangunpc.data.source.remote.network.ApiResult
import com.kaizen.bangunpc.data.source.remote.dto.ComponentDto
import com.kaizen.bangunpc.data.source.remote.dto.PCBuildDto
import com.kaizen.bangunpc.utils.SupabaseTables
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.query.Columns
import io.github.jan.supabase.postgrest.query.Order
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject

class ProductRDS @Inject constructor(
    private val postgrest: Postgrest
){
    suspend fun getAllCPUs() : Flow<ApiResult<List<ComponentDto>>> =
        flow {
            try {
                val result = postgrest[SupabaseTables.cpus]
                    .select(
                        columns = Columns.raw("gxcomp(*)")
                    ) {
                        order("id", Order.ASCENDING)
                    }
                val dataList = result.decodeList<ComponentDto>()
                if (dataList.isNotEmpty())
                    emit(ApiResult.Success(dataList))
                else
                    emit(ApiResult.Loading)
            } catch (e : Exception) {
                emit(ApiResult.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)

    suspend fun getAllGPUs() : Flow<ApiResult<List<ComponentDto>>> =
        flow {
            try {
                val result = postgrest[SupabaseTables.gpus]
                    .select(
                        columns = Columns.raw("gxcomp(*)")
                    ) {
                        order("id", Order.ASCENDING)
                    }
                val dataList = result.decodeList<ComponentDto>()
                if (dataList.isNotEmpty())
                    emit(ApiResult.Success(dataList))
                else
                    emit(ApiResult.Loading)
            } catch (e : Exception) {
                emit(ApiResult.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)

    suspend fun getAllCasings() : Flow<ApiResult<List<ComponentDto>>> =
        flow {
            try {
                val result = postgrest[SupabaseTables.casings]
                    .select(
                        columns = Columns.raw("gxcomp(*)")
                    ) {
                        order("id", Order.ASCENDING)
                    }
                val dataList = result.decodeList<ComponentDto>()
                if (dataList.isNotEmpty())
                    emit(ApiResult.Success(dataList))
                else
                    emit(ApiResult.Loading)
            } catch (e : Exception) {
                emit(ApiResult.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)

    suspend fun getAllMemories() : Flow<ApiResult<List<ComponentDto>>> =
        flow {
            try {
                val result = postgrest[SupabaseTables.memories]
                    .select(
                        columns = Columns.raw("gxcomp(*)")
                    ) {
                        order("id", Order.ASCENDING)
                    }
                val dataList = result.decodeList<ComponentDto>()
                if (dataList.isNotEmpty())
                    emit(ApiResult.Success(dataList))
                else
                    emit(ApiResult.Loading)
            } catch (e : Exception) {
                emit(ApiResult.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)

    suspend fun getAllMotherboards() : Flow<ApiResult<List<ComponentDto>>> =
        flow {
            try {
                val result = postgrest[SupabaseTables.motherboards]
                    .select(
                        columns = Columns.raw("gxcomp(*)")
                    ) {
                        order("id", Order.ASCENDING)
                    }
                val dataList = result.decodeList<ComponentDto>()
                if (dataList.isNotEmpty())
                    emit(ApiResult.Success(dataList))
                else
                    emit(ApiResult.Loading)
            } catch (e : Exception) {
                emit(ApiResult.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)

    suspend fun getAllPSUs() : Flow<ApiResult<List<ComponentDto>>> =
        flow {
            try {
                val result = postgrest[SupabaseTables.psus]
                    .select(
                        columns = Columns.raw("gxcomp(*)")
                    ) {
                        order("id", Order.ASCENDING)
                    }
                val dataList = result.decodeList<ComponentDto>()
                if (dataList.isNotEmpty())
                    emit(ApiResult.Success(dataList))
                else
                    emit(ApiResult.Loading)
            } catch (e : Exception) {
                emit(ApiResult.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)

    suspend fun getAllStorages() : Flow<ApiResult<List<ComponentDto>>> =
        flow {
            try {
                val result = postgrest[SupabaseTables.storages]
                    .select(
                        columns = Columns.raw("gxcomp(*)")
                    ) {
                        order("id", Order.ASCENDING)
                    }
                val dataList = result.decodeList<ComponentDto>()
                if (dataList.isNotEmpty())
                    emit(ApiResult.Success(dataList))
                else
                    emit(ApiResult.Loading)
            } catch (e : Exception) {
                emit(ApiResult.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)

    suspend fun getAllIntelPCs() : Flow<ApiResult<List<PCBuildDto>>> =
        flow {
            try {
                val result = postgrest[SupabaseTables.pcBuilds].select {
                    eq("category", 2)
                    order("id", Order.ASCENDING)
                }
                val dataList = result.decodeList<PCBuildDto>()
                if (dataList.isNotEmpty())
                    emit(ApiResult.Success(dataList))
                else
                    emit(ApiResult.Loading)
            } catch (e : Exception) {
                emit(ApiResult.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)

    suspend fun getAllAMDPCs() : Flow<ApiResult<List<PCBuildDto>>> =
        flow {
            try {
                val result = postgrest[SupabaseTables.pcBuilds].select {
                    eq("category", 1)
                    order("id", Order.ASCENDING)
                }
                val dataList = result.decodeList<PCBuildDto>()
                if (dataList.isNotEmpty())
                    emit(ApiResult.Success(dataList))
                else
                    emit(ApiResult.Loading)
            } catch (e : Exception) {
                emit(ApiResult.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
}