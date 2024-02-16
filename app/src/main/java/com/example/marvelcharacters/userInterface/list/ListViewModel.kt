package com.example.marvelcharacters.userInterface.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelcharacters.data.CharResponse
import com.example.marvelcharacters.data.CharacterData
import com.example.marvelcharacters.data.CharacterResponse
import com.example.marvelcharacters.domain.Character
import com.example.marvelcharacters.domain.CharacterService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(
    private val service: CharacterService
): ViewModel() {


//    init {
//        viewModelScope.launch(Dispatchers.IO) {
//            val list = getList()
//            getList.value = list
//        }
//    }
//    val getList: MutableState<CharacterResponse?> = mutableStateOf(null)
//
//
//    // val getList: MutableState<Character?> = mutableStateOf(null)
//
//
//    private suspend fun getList(): CharacterResponse {
//        return service.getListCharacters()
//    }

    suspend fun getCharacters2(): List<Character>
         = service.getListCharacters2()

    val getList2: MutableState<List<Character>> = mutableStateOf(emptyList())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val list = getCharacters2()
            getList2.value = list
        }
    }


}