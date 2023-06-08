package com.kaizen.bangunpc.di

import com.kaizen.bangunpc.MainViewModel
import com.kaizen.bangunpc.data.source.ProductRepository
import com.kaizen.bangunpc.ui.screen.catalog.CatalogViewModel
import com.kaizen.bangunpc.ui.screen.detail.DetailViewModel
import com.kaizen.bangunpc.ui.screen.home.HomeViewModel
import com.kaizen.bangunpc.ui.screen.wishlist.WishlistViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ViewModelModule {
    @Provides
    fun provideMainViewModel(repo: ProductRepository) : MainViewModel =
        MainViewModel(repo)

    @Provides
    fun provideHomeViewModel(repo: ProductRepository) : HomeViewModel =
        HomeViewModel(repo)

    @Provides
    fun provideDetailViewModel(repo: ProductRepository) : DetailViewModel =
        DetailViewModel(repo)
    @Provides
    fun provideCatalogViewModel(repo: ProductRepository) : CatalogViewModel =
        CatalogViewModel(repo)

    @Provides
    fun provideWishlistViewModel(repo: ProductRepository) : WishlistViewModel =
        WishlistViewModel(repo)
}