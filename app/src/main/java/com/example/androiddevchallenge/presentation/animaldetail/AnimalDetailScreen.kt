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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.model.Animal
import com.example.androiddevchallenge.utils.NetworkImage

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
    Box {
        NetworkImage(
            url = animal.url,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(4f / 3f)
        )
        TopAppBar(
            backgroundColor = Color.Transparent,
            elevation = 0.dp,
            contentColor = Color.White,
//        modifier = Modifier.statusBarsPadding()
        ) {
            IconButton(onClick = upPress) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = stringResource(id = R.string.label_back)
                )
            }
            Text(animal.name, modifier = Modifier.align(Alignment.CenterVertically))
            Spacer(modifier = Modifier.weight(1f))
        }
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