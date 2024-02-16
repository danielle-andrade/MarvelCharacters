package com.example.marvelcharacters.userInterface.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelcharacters.domain.Character
import com.example.marvelcharacters.domain.CharacterService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(
    private val service: CharacterService
): ViewModel() {


    suspend fun getCharacters(): List<Character>
         = service.getListCharacters()

    val getList2: MutableState<List<Character>> = mutableStateOf(emptyList())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val list = getCharacters()
            getList2.value = list
        }
    }
}