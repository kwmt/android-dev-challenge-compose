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
package com.example.androiddevchallenge.presentation.animallist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.domain.model.Animal

class AnimalListViewModel : ViewModel() {
    private val _animals = MutableLiveData<List<Animal>>()
    val animals: LiveData<List<Animal>> = _animals
    fun fetchAnimals() {
        _animals.value = createAnimalListData()
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