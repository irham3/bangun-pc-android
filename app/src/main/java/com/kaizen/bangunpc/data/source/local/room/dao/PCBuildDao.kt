package com.kaizen.bangunpc.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kaizen.bangunpc.data.source.local.entity.impl.PCBuildEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PCBuildDao {
    @Query("SELECT * FROM pcbuild")
    fun getAll() : Flow<List<PCBuildEntity>>

    @Query("SELECT * FROM pcbuild WHERE isFavorite = 1")
    fun getAllFavorites() : Flow<List<PCBuildEntity>>

    @Query("SELECT * FROM pcbuild WHERE category = 2")
    fun getAllIntelPCBuilds() : Flow<List<PCBuildEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pcBuildEntity: List<PCBuildEntity>)

    @Update
    fun update(pcBuildEntity: PCBuildEntity)
}