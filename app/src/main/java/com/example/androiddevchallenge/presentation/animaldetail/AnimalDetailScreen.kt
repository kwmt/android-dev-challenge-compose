package com.example.androiddevchallenge.presentation.animaldetail

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import com.example.androiddevchallenge.domain.model.Animal

@Composable
fun AnimalDetailScreen(animal: Animal?) {
    Log.d("tag", "$animal")
    BoxWithConstraints {
        val boxWidth = with(LocalDensity.current) { constraints.maxWidth.toDp() }
        val boxHeight = with(LocalDensity.current) { constraints.maxHeight.toDp() / 2 }
        Column {
            Box(
                Modifier
                    .size(boxWidth, boxHeight)
                    .fillMaxWidth()
                    .background(color = Color.Cyan)
            )
        }
    }
}