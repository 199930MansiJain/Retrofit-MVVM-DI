package com.example.retrofitdependencinjection.data.repository

import com.example.retrofitdependencinjection.core.common.Resource
import com.example.retrofitdependencinjection.data.api.CharacterApi
import com.example.retrofitdependencinjection.data.mapper.toDomainCharacter
import com.example.retrofitdependencinjection.domain.model.Character
import com.example.retrofitdependencinjection.domain.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val characterApi: CharacterApi) : CharacterRepository {

    override fun getAllCharacters(): Flow<Resource<List<Character>>> = flow {
        emit(Resource.Loading())
        val result = characterApi.fetchAllCharacters().map {
            it.toDomainCharacter()
        }
        emit(Resource.Success(result))
    }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.message.toString()))
        }
}