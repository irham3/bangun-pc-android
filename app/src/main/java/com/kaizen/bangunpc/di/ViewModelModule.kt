package com.kaizen.bangunpc.di

import com.kaizen.bangunpc.ui.screen.home.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ViewModelModule {
    @Provides
    fun provideHomeViewModel() : HomeViewModel =
        HomeViewModel()
}