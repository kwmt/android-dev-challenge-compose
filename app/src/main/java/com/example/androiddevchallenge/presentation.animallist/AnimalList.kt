package com.example.androiddevchallenge.presentation.animallist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.domain.model.Animal

@Composable
fun AnimalList(animals: List<Animal>) {
    LazyColumn {
        items(animals) { animal ->
            AnimalItem(animal) {
            }
        }

    }
}

@Composable
private fun AnimalItem(animal: Animal, onClick: () -> Unit) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
            .clickable(onClick = onClick)
            .background(Color.Cyan)
            .fillMaxWidth()
    ) {
        Column(
            Modifier.padding(4.dp)
        ) {
            Text(text = animal.name)
            Text(text = animal.name)
        }
    }
}

@Composable
@Preview
fun PreviewAnimalList() {
    AnimalList(animals = createAnimalListData())
}
