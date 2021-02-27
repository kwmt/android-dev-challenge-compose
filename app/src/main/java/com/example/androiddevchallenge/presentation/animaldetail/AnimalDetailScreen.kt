package com.example.androiddevchallenge.presentation.animaldetail

import android.util.Log
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.model.Animal

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