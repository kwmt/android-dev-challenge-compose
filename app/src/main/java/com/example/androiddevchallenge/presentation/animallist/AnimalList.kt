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

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.domain.model.Animal
import com.example.androiddevchallenge.presentation.components.AnimalImage
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@Composable
fun AnimalList(animals: List<Animal>, selectAnimal: (Animal) -> Unit) {
    LazyColumn(
        Modifier
            .statusBarsPadding()
    ) {
        items(animals) { animal ->
            AnimalItem(animal, selectAnimal, Modifier.height(96.dp))
        }
    }
}

@Composable
private fun AnimalItem(animal: Animal, onClick: (Animal) -> Unit, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
    ) {
        Row(modifier = Modifier.clickable(onClick = { onClick(animal) })) {
            AnimalImage(animal.url, modifier = Modifier.aspectRatio(1f))
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(animal.name)
            }
        }
    }
}
