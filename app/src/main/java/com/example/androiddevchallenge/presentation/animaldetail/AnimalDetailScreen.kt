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
package com.example.androiddevchallenge.presentation.animaldetail

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.model.Animal
import com.example.androiddevchallenge.ui.theme.Neutral8
import com.example.androiddevchallenge.utils.NetworkImage
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@Composable
fun AnimalDetailScreen(animal: Animal, upPress: () -> Unit) {
    Log.d("tag", "$animal")
    AnimalDetailContents(animal, upPress)
}

@Composable
private fun AnimalDetailContents(animal: Animal, upPress: () -> Unit) {
    LazyColumn {
        item { AnimalDetailHeader(animal, upPress) }
    }
}

@Composable
private fun AnimalDetailHeader(animal: Animal, upPress: () -> Unit) {
    Box(Modifier.fillMaxSize()) {
        NetworkImage(
            url = animal.url,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(4f / 3f)
        )
        Up(upPress)
    }
}

@Composable
private fun Up(
    upPress: () -> Unit,
) {
    IconButton(
        onClick = upPress,
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .size(36.dp)
            .background(
                color = Neutral8.copy(alpha = 0.32f),
                shape = CircleShape
            )
    ) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = stringResource(id = R.string.label_back)
        )
    }
}

@Preview
@Composable
private fun PreviewAnimalDetailScreen() {
    AnimalDetailScreen(
        animal = Animal(
            1,
            "test",
            "https://images.dog.ceo/breeds/hound-ibizan/n02091244_440.jpg"
        ), upPress = { /*TODO*/ })
}