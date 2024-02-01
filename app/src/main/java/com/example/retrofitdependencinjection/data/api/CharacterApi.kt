package com.example.retrofitdependencinjection.data.api

import com.example.retrofitdependencinjection.data.dto.CharactersDto
import retrofit2.http.GET

interface CharacterApi {
    @GET("characters")
    suspend fun fetchAllCharacters() : List<CharactersDto>
}