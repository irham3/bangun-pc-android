package com.kaizen.bangunpc.di

import com.kaizen.bangunpc.data.source.repository.UserRepository
import com.kaizen.bangunpc.data.source.repository.impl.ProductRepositoryImpl
import com.kaizen.bangunpc.data.source.repository.ProductRepository
import com.kaizen.bangunpc.data.source.repository.impl.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [SupabaseModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindProductRepository(productRepositoryImpl: ProductRepositoryImpl) : ProductRepository

    @Singleton
    @Binds
    abstract fun bindUserRepository(repository: UserRepositoryImpl) : UserRepository
}