package com.kaizen.bangunpc.data.source.local.datasource

import com.kaizen.bangunpc.data.source.local.entity.impl.PCBuildEntity
import com.kaizen.bangunpc.data.source.local.room.dao.PCBuildDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PCBuildLDS @Inject constructor(
    private val pcBuildDao: PCBuildDao
) {
    suspend fun insert(pcBuildList: List<PCBuildEntity>) =
        pcBuildDao.insert(pcBuildList)

    fun getAll() : Flow<List<PCBuildEntity>> =
        pcBuildDao.getAll()

    fun setFavorite(pcBuildEntity: PCBuildEntity, newStatus: Boolean) {
        pcBuildEntity.isFavorite = newStatus
        pcBuildDao.update(pcBuildEntity)
    }
}