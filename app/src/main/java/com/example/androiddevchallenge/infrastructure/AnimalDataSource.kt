package com.example.androiddevchallenge.infrastructure

import com.example.androiddevchallenge.domain.model.Animal
import com.example.androiddevchallenge.domain.repository.AnimalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AnimalDataSource(
    private val remoteDataSource: AnimalRemoteDataSource,
    private val localDataSource: AnimalLocalDataSource
) : AnimalRepository {
    override fun fetchAnimals(): Flow<List<Animal>> {
        return localDataSource.latestAnimals
    }
}

class AnimalRemoteDataSource {
}

class AnimalLocalDataSource {
    val latestAnimals: Flow<List<Animal>> = flow {
        emit(createAnimalListData())
    }
}

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
