package com.example.retrofitdependencinjection.data.repository

import com.example.retrofitdependencinjection.core.common.LocalResponseResult
import com.example.retrofitdependencinjection.core.common.Resource
import com.example.retrofitdependencinjection.core.utils.Constants
import com.example.retrofitdependencinjection.data.api.CharacterApi
import com.example.retrofitdependencinjection.data.mapper.toDomainCharacter
import com.example.retrofitdependencinjection.data.room.AppDatabase
import com.example.retrofitdependencinjection.domain.model.Character
import com.example.retrofitdependencinjection.domain.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.w3c.dom.CharacterData
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val characterApi: CharacterApi,private val appDB : AppDatabase) : CharacterRepository {

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

    override fun getListFromDB(id: String): Flow<LocalResponseResult> {
        return flow {
            try {
                appDB.characterDao.getCharactersById(id).collect {
                    emit(LocalResponseResult.Success(it, Constants.GET_BY_ID))
                }
            } catch (e: Exception) {
                emit(LocalResponseResult.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun insertAllDataToDB(listCharacterData: List<CharacterData>): Flow<LocalResponseResult> {
        return flow {
            try {
                appDB.characterDao.insertCharacters(listCharacterData).collect {
                    emit(LocalResponseResult.Success(it, Constants.INSERT_ALL_DATA))
                }
            } catch (e: Exception) {
                emit(LocalResponseResult.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }


}