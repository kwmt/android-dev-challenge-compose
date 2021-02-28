package com.example.androiddevchallenge.infrastructure

import android.content.Context
import android.content.res.AssetManager
import com.example.androiddevchallenge.domain.model.Animal
import com.example.androiddevchallenge.domain.repository.AnimalRepository
import com.example.androiddevchallenge.infrastructure.model.AnimalResponse
import com.example.androiddevchallenge.infrastructure.model.AnimalsResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import javax.inject.Inject

class AnimalDataSource @Inject constructor(
    private val remoteDataSource: AnimalRemoteDataSource,
    private val localDataSource: AnimalLocalDataSource
) : AnimalRepository {
    override fun fetchAnimals(): Flow<List<Animal>> {
        return remoteDataSource.latestAnimals
        //localDataSource.latestAnimals
    }
}

class AnimalRemoteDataSource @Inject constructor(
    api: Api
) {
    val latestAnimals: Flow<List<Animal>> = api.fetchAnimalData().map { it.toModel() }
}

class AnimalLocalDataSource @Inject constructor() {
    val latestAnimals: Flow<List<Animal>> = flow {
        emit(createAnimalListData())
    }
}

class Api @Inject constructor(
    @ApplicationContext context: Context,
) {
    private val assetManager = context.assets
    fun fetchAnimalData(): Flow<AnimalsResponse> = flow {
        val json = assetManager.readAssetsFile("mock_data.json")
        val element = Json.decodeFromString<List<AnimalResponse>>(json)
        emit(AnimalsResponse(element))
    }
}

private fun AssetManager.readAssetsFile(fileName: String): String =
    open(fileName).bufferedReader().use { it.readText() }

fun createAnimalListData(): List<Animal> {
    return listOf(
        Animal(1, "Bella"),
        Animal(2, "Molly"),
        Animal(3, "Lucy"),
        Animal(4, "Maggie"),
        Animal(5, "Daisy"),
        Animal(6, "Sadie"),
        Animal(7, "Chloe"),
        Animal(8, "Sophie"),
        Animal(9, "Sophie"),
        Animal(10, "Sophie"),
    )
}
