package com.example.retrofitdependencinjection.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitdependencinjection.core.common.Resource
import com.example.retrofitdependencinjection.domain.model.Character
import com.example.retrofitdependencinjection.domain.usecase.GetAllCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.w3c.dom.CharacterData
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val useCase: GetAllCharacterUseCase) :
    ViewModel() {

    private val _response: MutableLiveData<List<Character>?> = MutableLiveData()
    val response: MutableLiveData<List<Character>?> = _response

    private val _errorMsg: MutableLiveData<String?> = MutableLiveData()
    val errorMsg: MutableLiveData<String?> = _errorMsg

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        getAllCharacters()
    }

    private fun getAllCharacters() {
        useCase().onEach {
            when (it) {
                is Resource.Error -> {
                    _errorMsg.value = it.msg
                }

                is Resource.Loading -> {
                    _isLoading.value = true

                }

                is Resource.Success -> {
                    _isLoading.value = false
                    _response.value = it.data
                    inserDataTODB(it.data as List<CharacterData>)

                }
            }

        }.launchIn(viewModelScope)
    }

    private fun inserDataTODB(list : List<CharacterData>){
        useCase.getAllDataFormLocal(list)
    }
}