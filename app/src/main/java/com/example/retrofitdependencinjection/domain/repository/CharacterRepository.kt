package com.example.retrofitdependencinjection.domain.repository

import com.example.retrofitdependencinjection.core.common.Resource
import com.example.retrofitdependencinjection.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getAllCharacters() : Flow<Resource<List<Character>>>
}