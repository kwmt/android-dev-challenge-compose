package com.example.androiddevchallenge.presentation.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.utils.NetworkImage

@Composable
fun AnimalImage(
    url: String,
    modifier: Modifier = Modifier,
) {
    Surface(
        elevation = 0.dp,
        shape = CircleShape,
        modifier = modifier,
    ) {
        NetworkImage(
            url = url,
            contentDescription = null,
            modifier = modifier
        )
    }
}