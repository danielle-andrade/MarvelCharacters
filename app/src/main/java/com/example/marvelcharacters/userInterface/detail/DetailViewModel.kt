package com.example.marvelcharacters.userInterface.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelcharacters.data.CharacterData
import com.example.marvelcharacters.domain.CharacterService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(
    private val service: CharacterService
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val listCharacter = service.getListCharacters()

            val character = listCharacter.firstOrNull()

            if(character != null) {
                val personagemId = character.id
                val data = getCharacter2(personagemId)
                withContext(Dispatchers.Main) {
                    getCharacter2.value = data
                }
            }
        }
    }

    suspend fun getCharacter2(id: Int): CharacterData =
         service.getCharacter(id)

val getCharacter2: MutableState<CharacterData?> = mutableStateOf(null)

}

//    init {
//        viewModelScope.launch(Dispatchers.IO) {
//            val data = getCharacter2()
//            withContext(Dispatchers.Main) {
//                getCharacter2.value = data
//            }
//        }
//    }



