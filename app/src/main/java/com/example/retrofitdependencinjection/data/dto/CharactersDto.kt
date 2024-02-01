package com.example.retrofitdependencinjection.data.dto


data class CharactersDto(
    val actor: String,
    val alive: Boolean,
    val alternate_actors: List<String>,
    val alternate_names: List<String>,
    val ancestry: String,
    val dateOfBirth: String,
    val eyeColour: String,
    val gender: String,
    val hairColour: String,
    val hogwartsStaff: Boolean,
    val hogwartsStudent: Boolean,
    val house: String,
    val id: String,
    val image: String,
    val name: String,
    val patronus: String,
    val species: String,
    val wand: WandDto,
    val wizard: Boolean,
    val yearOfBirth: Int
)

data class WandDto(
    val core: String,
    val length: Double,
    val wood: String
)