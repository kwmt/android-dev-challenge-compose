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
package com.example.androiddevchallenge.infrastructure

import android.content.Context
import android.content.res.AssetManager
import com.example.androiddevchallenge.domain.model.Animal
import com.example.androiddevchallenge.domain.repository.AnimalRepository
import com.example.androiddevchallenge.infrastructure.model.AnimalResponse
import com.example.androiddevchallenge.infrastructure.model.DogImage
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import javax.inject.Inject

class AnimalDataSource @Inject constructor(
    private val remoteDataSource: AnimalRemoteDataSource,
    private val localDataSource: AnimalLocalDataSource
) : AnimalRepository {
    override fun fetchAnimals(): Flow<List<Animal>> {
        return remoteDataSource.latestAnimals
        // localDataSource.latestAnimals
    }
}

class AnimalRemoteDataSource @Inject constructor(
    api: Api
) {
    val latestAnimals: Flow<List<Animal>> = api.fetchAnimalData()
}

class AnimalLocalDataSource @Inject constructor() {
    val latestAnimals: Flow<List<Animal>> = flow {
//        emit(createAnimalListData())
    }
}

class Api @Inject constructor(
    @ApplicationContext context: Context,
) {
    private val assetManager = context.assets
    fun fetchAnimalData(): Flow<List<Animal>> = flow {
        val json = assetManager.readAssetsFile("mock_data.json")
        val element = Json.decodeFromString<List<AnimalResponse>>(json)
        val dogImagesJson = assetManager.readAssetsFile("dog_images.json")
        val dogImage = Json.decodeFromString<DogImage>(dogImagesJson)
        val result = element.mapIndexed { index, animalResponse ->
            Animal(
                id = animalResponse.id,
                name = animalResponse.name,
                description = animalResponse.description,
                city = animalResponse.city,
                gender = animalResponse.gender,
                color = animalResponse.color,
                url = dogImage.urls[index % dogImage.urls.size]
            )
        }
        emit(result)
    }
}

private fun AssetManager.readAssetsFile(fileName: String): String =
    open(fileName).bufferedReader().use { it.readText() }
