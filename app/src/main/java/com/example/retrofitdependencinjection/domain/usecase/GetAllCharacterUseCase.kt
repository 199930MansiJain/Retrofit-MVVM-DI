package com.example.retrofitdependencinjection.domain.usecase

import com.example.retrofitdependencinjection.domain.repository.CharacterRepository
import javax.inject.Inject

class GetAllCharacterUseCase @Inject constructor(private val characterRepository: CharacterRepository) {
    operator fun invoke() = characterRepository.getAllCharacters()

}