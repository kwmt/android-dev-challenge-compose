package com.example.androiddevchallenge.application.di

import android.content.Context
import com.example.androiddevchallenge.domain.repository.AnimalRepository
import com.example.androiddevchallenge.infrastructure.AnimalDataSource
import com.example.androiddevchallenge.infrastructure.AnimalLocalDataSource
import com.example.androiddevchallenge.infrastructure.AnimalRemoteDataSource
import com.example.androiddevchallenge.infrastructure.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {
    @Provides
    @ViewModelScoped
    fun provideRepository(
        remoteDataSource: AnimalRemoteDataSource,
        localDataSource: AnimalLocalDataSource
    ): AnimalRepository = AnimalDataSource(
        remoteDataSource,
        localDataSource
    )
}

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    fun provideApi(
        @ApplicationContext context: Context
    ): Api {
        return Api(context)
    }
}
