package com.example.retrofitdependencinjection.domain.repository

import com.example.retrofitdependencinjection.core.common.LocalResponseResult
import com.example.retrofitdependencinjection.core.common.Resource
import com.example.retrofitdependencinjection.domain.model.Character
import kotlinx.coroutines.flow.Flow
import org.w3c.dom.CharacterData

interface CharacterRepository {

    fun getAllCharacters() : Flow<Resource<List<Character>>>

     fun insertAllDataToDB(listCharacterData: List<CharacterData>) :Flow<LocalResponseResult>

    fun getListFromDB(id: String) :Flow<LocalResponseResult>


}