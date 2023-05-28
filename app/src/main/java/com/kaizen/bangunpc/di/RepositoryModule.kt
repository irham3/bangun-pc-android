package com.kaizen.bangunpc.di

import com.kaizen.bangunpc.data.source.ComponentRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(componentRepository: ComponentRepository)
}