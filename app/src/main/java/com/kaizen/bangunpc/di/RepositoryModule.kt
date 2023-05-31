package com.kaizen.bangunpc.di

import com.kaizen.bangunpc.data.source.ComponentRepository
import com.kaizen.bangunpc.data.source.IComponentRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(componentRepository: ComponentRepository) : IComponentRepository
}