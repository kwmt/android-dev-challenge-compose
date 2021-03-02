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
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.util.lerp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.model.Animal
import com.example.androiddevchallenge.presentation.components.AnimalImage
import com.example.androiddevchallenge.ui.theme.DevChallengeTheme
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.Neutral8
import com.example.androiddevchallenge.ui.theme.Ocean3
import com.example.androiddevchallenge.ui.theme.Shadow3
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsPadding
import kotlin.math.max
import kotlin.math.min

private val GradientScroll = 180.dp
private val ImageOverlap = 115.dp
private val MinTitleOffset = 72.dp
private val MinImageOffset = 12.dp
private val MaxTitleOffset = ImageOverlap + MinTitleOffset + GradientScroll

// 115 + 56 + 180 = 351
private val TitleHeight = 128.dp
private val ExpandedImageSize = 300.dp
private val CollapsedImageSize = 150.dp
private val HzPadding = Modifier.padding(horizontal = 24.dp)

@Composable
fun AnimalDetailScreen(animal: Animal, upPress: () -> Unit) {
    Log.d("tag", "$animal")
    AnimalDetailContents(animal, upPress)
}

@Composable
private fun AnimalDetailContents(animal: Animal, upPress: () -> Unit) {
    Box(Modifier.fillMaxSize()) {
        val scroll = rememberScrollState(0)
        Header()
        Body(animal, scroll)
        Title(animal, scroll.value)
        Up(upPress)
        MainDogImage(imageUrl = animal.url, scroll = scroll.value)
    }
}

@Composable
private fun Title(animal: Animal, scroll: Int) {
    val maxOffset = with(LocalDensity.current) { MaxTitleOffset.toPx() }
    val minOffset = with(LocalDensity.current) { MinTitleOffset.toPx() }
    val offset = (maxOffset - scroll).coerceAtLeast(minOffset)

    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .heightIn(min = TitleHeight)
            .statusBarsPadding()
            .fillMaxWidth()
            .graphicsLayer { translationY = offset }
            .background(DevChallengeTheme.colors.uiBackground)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = animal.name,
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primary,
            modifier = HzPadding
        )
        Text(
            text = animal.city,
            style = MaterialTheme.typography.subtitle2,
            color = MaterialTheme.colors.primary,
            modifier = HzPadding
        )
        Text(
            text = animal.gender,
            style = MaterialTheme.typography.subtitle2,
            color = MaterialTheme.colors.primary,
            modifier = HzPadding
        )
        Spacer(Modifier.height(8.dp))
    }
}

@Composable
private fun Body(animal: Animal, scroll: ScrollState) {
    Column {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .height(MinTitleOffset)
        )
        Column(modifier = Modifier.verticalScroll(scroll)) {
            Spacer(modifier = Modifier.height(GradientScroll))
            Surface(modifier = Modifier.fillMaxWidth()) {
                Column {
                    Spacer(modifier = Modifier.height(ImageOverlap))
                    Spacer(modifier = Modifier.height(TitleHeight))
                    Text(
                        text = stringResource(id = R.string.detail_header),
                        modifier = HzPadding
                    )
                    Text(
                        text = animal.description,
                        modifier = HzPadding
                    )
                    Text(
                        text = animal.description,
                        modifier = HzPadding
                    )
                    Text(
                        text = animal.description,
                        modifier = HzPadding
                    )
                    Text(
                        text = animal.description,
                        modifier = HzPadding
                    )
                    Text(
                        text = animal.description,
                        modifier = HzPadding
                    )
                    Text(
                        text = animal.description,
                        modifier = HzPadding
                    )
                    Text(
                        text = animal.description,
                        modifier = HzPadding
                    )
                    Text(
                        text = animal.description,
                        modifier = HzPadding
                    )
                    Text(
                        text = animal.description,
                        modifier = HzPadding
                    )
                    Text(
                        text = animal.description,
                        modifier = HzPadding
                    )
                    Text(
                        text = animal.description,
                        modifier = HzPadding
                    )
                    Text(
                        text = animal.description,
                        modifier = HzPadding
                    )
                    Text(
                        text = animal.description,
                        modifier = HzPadding
                    )
                    Text(
                        text = animal.description,
                        modifier = HzPadding
                    )
                    Text(
                        text = animal.description,
                        modifier = HzPadding
                    )
                    Spacer(
                        Modifier
                            .navigationBarsPadding(left = false, right = false)
                            .height(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun Header() {
    Spacer(
        modifier = Modifier
            .height(280.dp)
            .fillMaxWidth()
            .background(
                Brush.horizontalGradient(
                    listOf(Ocean3, Shadow3)
                )
            )
    )
}

@Composable
private fun MainDogImage(
    imageUrl: String,
    scroll: Int,
) {
    val collapseRange = with(LocalDensity.current) { (MaxTitleOffset - MinTitleOffset).toPx() }
    val collapseFraction = (scroll / collapseRange).coerceIn(0f, 1f)
    CollapsingImageLayout(
        collapseFraction = collapseFraction,
        modifier = HzPadding.then(Modifier.statusBarsPadding())
    ) {
        AnimalImage(url = imageUrl, modifier = Modifier.fillMaxSize())
    }
}

@Composable
private fun CollapsingImageLayout(
    collapseFraction: Float,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(
        modifier = modifier,
        content = content,
    ) { measurables, constraints ->
        check(measurables.size == 1)
        val imageMaxSize = min(ExpandedImageSize.roundToPx(), constraints.maxWidth)
        val imageMinSize = max(CollapsedImageSize.roundToPx(), constraints.minWidth)
        val imageWidth = lerp(imageMaxSize, imageMinSize, collapseFraction)
        val imagePlaceable = measurables[0].measure(Constraints.fixed(imageWidth, imageWidth))
        val imageY = lerp(MinTitleOffset, MinImageOffset, collapseFraction).roundToPx()
        val imageX = lerp(
            (constraints.maxWidth - imageWidth) / 2,
            constraints.maxWidth - imageWidth,
            collapseFraction
        )

        layout(
            width = constraints.maxWidth,
            height = imageY + imageWidth
        ) {
            imagePlaceable.place(imageX, imageY)
        }
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
    MyTheme {
        AnimalDetailScreen(
            animal = Animal(
                1,
                "test",
                "test",
                "city",
                "gender",
                "#ffffff",
                "https://images.dog.ceo/breeds/hound-ibizan/n02091244_440.jpg"
            ),
            upPress = { /*TODO*/ }
        )
    }
}
