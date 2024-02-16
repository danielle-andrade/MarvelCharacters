package com.example.marvelcharacters.userInterface.detail

import androidx.compose.runtime.MutableState
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
import kotlinx.coroutines.withContext
import java.util.NoSuchElementException

class DetailViewModel(
    private val service: CharacterService
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val lista = service.getListCharacters2()

            val personagemSelecionado = lista.firstOrNull()

            if(personagemSelecionado != null) {
                val personagemId = personagemSelecionado.id
                val data = getCharacter2(personagemId)
                withContext(Dispatchers.Main) {
                    getCharacter2.value = data
                }
            }
        }
    }

    val getCharacter: MutableState<CharacterData?> = mutableStateOf(null)

//     suspend fun getCharacter(id: Int): CharResponse {
//         val teste = service.getCharacter(id)
//         return teste.results.firstOrNull() ?: throw NoSuchElementException("No character found")
//}
    suspend fun getCharacter2(id: Int): Character =
         service.getCharacter2(id)


//    init {
//        viewModelScope.launch(Dispatchers.IO) {
//            val data = getCharacter2()
//            withContext(Dispatchers.Main) {
//                getCharacter2.value = data
//            }
//        }
//    }

    val getCharacter2: MutableState<Character?> = mutableStateOf(null)


}
