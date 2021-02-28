/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
