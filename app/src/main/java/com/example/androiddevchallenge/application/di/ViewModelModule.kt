package com.example.androiddevchallenge.application.di

import com.example.androiddevchallenge.domain.repository.AnimalRepository
import com.example.androiddevchallenge.infrastructure.AnimalDataSource
import com.example.androiddevchallenge.infrastructure.AnimalLocalDataSource
import com.example.androiddevchallenge.infrastructure.AnimalRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {
    @Provides
    @ViewModelScoped
    fun provideRepository(): AnimalRepository = AnimalDataSource(
        AnimalRemoteDataSource(),
        AnimalLocalDataSource()
    )
}