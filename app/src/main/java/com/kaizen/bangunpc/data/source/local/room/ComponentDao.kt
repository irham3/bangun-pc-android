package com.kaizen.bangunpc.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kaizen.bangunpc.data.source.local.entity.ComponentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ComponentDao {
    @Query("SELECT * FROM component")
    fun getAllComponents() : Flow<List<ComponentEntity>>

    @Query("SELECT * FROM component WHERE isFavorite = 1")
    fun getFavoriteComponents() : Flow<List<ComponentEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComponent(componentEntity: List<ComponentEntity>)

    @Update
    fun updateFavoriteComponent(componentEntity: ComponentEntity)
}