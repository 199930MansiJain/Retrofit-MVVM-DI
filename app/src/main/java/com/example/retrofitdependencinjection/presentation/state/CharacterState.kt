package com.example.retrofitdependencinjection.presentation.state

import com.example.retrofitdependencinjection.domain.model.Character

data class CharacterState (
    val listOfCharacters : List<Character>? = mutableListOf(),
    val errorMsg : String? = null,
    val isLoading : Boolean = false,

)