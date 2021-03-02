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

private val DarkColorPalette = DevChallengeColors(
    uiBackground = Neutral8,
//    primary = purple200,
//    primaryVariant = purple700,
//    secondary = teal200
)

private val LightColorPalette = DevChallengeColors(
    uiBackground = Neutral0,
//    primary = purple500,
//    primaryVariant = purple700,
//    secondary = teal200

        /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
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
class DevChallengeColors(uiBackground: Color,) {
    var uiBackground by mutableStateOf(uiBackground)
        private set

    fun update(other: DevChallengeColors) {
        uiBackground = other.uiBackground
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
