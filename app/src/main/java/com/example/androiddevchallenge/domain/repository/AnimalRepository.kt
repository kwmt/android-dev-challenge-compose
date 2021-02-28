package com.example.androiddevchallenge.domain.repository

import com.example.androiddevchallenge.domain.model.Animal
import kotlinx.coroutines.flow.Flow

interface AnimalRepository {
    fun fetchAnimals(): Flow<List<Animal>>
}