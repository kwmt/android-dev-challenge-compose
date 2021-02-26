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
        Animal("Bella"),
        Animal("Molly"),
        Animal("Lucy"),
        Animal("Maggie"),
        Animal("Daisy"),
        Animal("Sadie"),
        Animal("Chloe"),
        Animal("Sophie"),
        Animal("Sophie"),
        Animal("Sophie"),
        Animal("Sophie"),
        Animal("Sophie"),
        Animal("Sophie"),
        Animal("Sophie"),
        Animal("Sophie"),
        Animal("Sophie"),
        Animal("Sophie"),
        Animal("Sophie"),
        Animal("Sophie"),
        Animal("Sophie"),
        Animal("Sophie"),
        Animal("Sophie"),
        Animal("Sophie"),
        Animal("Sophie"),
    )
}