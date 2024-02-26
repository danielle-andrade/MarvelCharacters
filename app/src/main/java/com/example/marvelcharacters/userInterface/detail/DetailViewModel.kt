package com.example.marvelcharacters.userInterface.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.marvelcharacters.domain.Character
import com.example.marvelcharacters.domain.CharacterService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(
    private val service: CharacterService,
) : ScreenModel {

    val character: MutableState<Character?> = mutableStateOf(null)

    suspend fun getCharacter(id: Int) {
        val char = service.getCharacter(id)
        character.value = char
    }
}



