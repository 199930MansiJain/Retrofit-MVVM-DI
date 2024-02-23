package com.example.retrofitdependencinjection.domain.usecase

import com.example.retrofitdependencinjection.domain.repository.CharacterRepository
import org.w3c.dom.CharacterData
import javax.inject.Inject

class GetAllCharacterUseCase @Inject constructor(private val characterRepository: CharacterRepository) {
    operator fun invoke() = characterRepository.getAllCharacters()

    fun getAllDataFormLocal(list: List<CharacterData>) = characterRepository.insertAllDataToDB(list)

    fun getAllDataFormLocalById(id: String) = characterRepository.getListFromDB(id)


}