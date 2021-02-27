package com.example.androiddevchallenge.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import com.example.androiddevchallenge.ui.theme.compositedOnSurface
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun NetworkImage(
    url: String,
    contentDescription: String?,
    modifier: Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    placeholderColor: Color? = MaterialTheme.colors.compositedOnSurface(0.2f)
) {
    CoilImage(
        data = url,
        modifier = modifier,
        contentDescription = contentDescription,
        contentScale = contentScale,
        loading = {
            if (placeholderColor != null) {
                Spacer(modifier = Modifier
                    .fillMaxSize()
                    .background(placeholderColor))
            }
        }
    )
}