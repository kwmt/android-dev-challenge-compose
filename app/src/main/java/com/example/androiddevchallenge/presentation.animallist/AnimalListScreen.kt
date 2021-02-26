package com.example.androiddevchallenge.presentation.animallist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.domain.model.Animal

@Composable
fun AnimalListScreen(viewModel: AnimalListViewModel = viewModel()) {

    val animals: List<Animal> by viewModel.animals.observeAsState(initial = listOf())

    viewModel.fetchAnimals()
    AnimalList(animals = animals)
}


