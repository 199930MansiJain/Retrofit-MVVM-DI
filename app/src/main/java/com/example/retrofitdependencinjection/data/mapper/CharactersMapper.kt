package com.example.retrofitdependencinjection.data.mapper

import com.example.retrofitdependencinjection.data.dto.CharactersDto
import com.example.retrofitdependencinjection.domain.model.Character

fun CharactersDto.toDomainCharacter() : Character{
    return Character(actor, id, image, name)
}