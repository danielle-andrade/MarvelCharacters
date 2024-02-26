package com.example.marvelcharacters.userInterface.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.marvelcharacters.domain.Character
import com.example.marvelcharacters.domain.CharacterService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(
    private val service: CharacterService,
): ScreenModel {
    suspend fun getCharacters(): List<Character>
         = service.getListCharacters()

    val getList: MutableState<List<Character>> = mutableStateOf(emptyList())

    init {
        screenModelScope.launch(Dispatchers.IO) {
            val list = getCharacters()
            getList.value = list
        }
    }
}