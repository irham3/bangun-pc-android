package com.kaizen.bangunpc.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kaizen.bangunpc.data.source.local.entity.ProductEntity
import com.kaizen.bangunpc.data.source.local.room.dao.ProductDao

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getProductDao(): ProductDao
}