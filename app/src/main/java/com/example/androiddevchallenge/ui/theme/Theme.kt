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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val LightColorPalette = DevChallengeColors(
    uiBackground = Neutral0,
    textPrimary = Shadow5,
    textSecondary = Neutral7,
    gradient2_1 = listOf(Shadow4, Shadow11),

)
private val DarkColorPalette = DevChallengeColors(
    uiBackground = Neutral8,
    textPrimary = Shadow1,
    textSecondary = Neutral0,
    gradient2_1 = listOf(Ocean3, Shadow3),
)

@Composable
fun MyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    ProvideDevChallengeColors(colors) {
        MaterialTheme(
//            colors = colors,
            typography = typography,
            shapes = shapes,
            content = content
        )
    }
}

object DevChallengeTheme {
    val colors: DevChallengeColors
        @Composable
        get() = LocalDevChallengeColors.current
}

@Stable
class DevChallengeColors(
    uiBackground: Color,
    textPrimary: Color,
    textSecondary: Color,
    gradient2_1: List<Color>,
    interactivePrimary: List<Color> = gradient2_1,
) {
    var uiBackground by mutableStateOf(uiBackground)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var textSecondary by mutableStateOf(textSecondary)
        private set
    var interactivePrimary by mutableStateOf(interactivePrimary)
        private set

    fun update(other: DevChallengeColors) {
        uiBackground = other.uiBackground
        textPrimary = other.textPrimary
        textSecondary = other.textSecondary
    }
}

@Composable
fun ProvideDevChallengeColors(
    colors: DevChallengeColors,
    content: @Composable () -> Unit
) {
    val colorPalette = remember { colors }
    colorPalette.update(colors)
    CompositionLocalProvider(LocalDevChallengeColors provides colorPalette, content = content)
}

private val LocalDevChallengeColors = staticCompositionLocalOf<DevChallengeColors> {
    error("No DevChallengeColorPalette provided")
}
