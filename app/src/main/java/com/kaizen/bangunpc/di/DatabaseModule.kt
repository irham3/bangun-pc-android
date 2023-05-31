package com.kaizen.bangunpc.di

import android.content.Context
import androidx.room.Room
import com.kaizen.bangunpc.data.source.local.room.ComponentDao
import com.kaizen.bangunpc.data.source.local.room.ComponentDatabase
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
    fun provideDatabase(@ApplicationContext context: Context) : ComponentDatabase =
        Room.databaseBuilder(
            context,
            ComponentDatabase::class.java, "Component.db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideComponentDao(database: ComponentDatabase) : ComponentDao =
        database.getComponentDao()
}