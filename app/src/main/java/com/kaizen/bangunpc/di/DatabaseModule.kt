package com.kaizen.bangunpc.di

import android.content.Context
import androidx.room.Room
import com.kaizen.bangunpc.data.source.local.room.dao.ProductDao
import com.kaizen.bangunpc.data.source.local.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) : AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java, "App.db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideProductDao(database: AppDatabase) : ProductDao =
        database.getProductDao()
}