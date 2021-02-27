package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.MainDestinations.ANIMAL_DETAIL_ID_KEY
import com.example.androiddevchallenge.MainDestinations.ANIMAL_DETAIL_ROUTE
import com.example.androiddevchallenge.MainDestinations.ANIMAL_MODEL_KEY
import com.example.androiddevchallenge.domain.model.Animal
import com.example.androiddevchallenge.presentation.animaldetail.AnimalDetailScreen
import com.example.androiddevchallenge.presentation.animallist.AnimalListScreen
import java.lang.IllegalArgumentException

object MainDestinations {
    const val ANIMALS_ROUTE = "animals"
    const val ANIMAL_DETAIL_ROUTE = "animal"
    const val ANIMAL_DETAIL_ID_KEY = "animalId"
    const val ANIMAL_MODEL_KEY = "animal"
}

@Composable
fun NavGraph(startDestination: String = MainDestinations.ANIMALS_ROUTE) {
    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(MainDestinations.ANIMALS_ROUTE) {
            AnimalListScreen(selectAnimal = actions.selectAnimal)
        }
        composable("$ANIMAL_DETAIL_ROUTE/{$ANIMAL_DETAIL_ID_KEY}") {
            val animal = navController.previousBackStackEntry?.arguments?.getParcelable<Animal>(
                ANIMAL_MODEL_KEY
            ) ?: throw IllegalArgumentException()
            AnimalDetailScreen(animal, actions.upPress)
        }
    }
}

class MainActions(navController: NavController) {
    val selectAnimal: (Animal) -> Unit = { animal: Animal ->
        navController.currentBackStackEntry?.arguments?.putParcelable(ANIMAL_MODEL_KEY, animal)
        navController.navigate("$ANIMAL_DETAIL_ROUTE/${animal.id}")
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}