package com.example.androiddevchallenge.infrastructure.model

import com.example.androiddevchallenge.domain.model.Animal
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class AnimalsResponse(
    val list: List<AnimalResponse>
) {
    fun toModel(): List<Animal> {
        return list.map {
            Animal(it.id, it.name)
        }
    }
}

@Serializable
data class AnimalResponse(
    val id: Int,
    val name: String,
    val description: String,
    val city: String,
    val gender: String,
    @SerialName("clor")
    val color: String,
)

