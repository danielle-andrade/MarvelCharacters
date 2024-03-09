package com.example.marvelcharacters.userInterface.list

import androidx.compose.runtime.MutableState
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.marvelcharacters.data.CharacterGateway
import com.example.marvelcharacters.domain.Character
import com.example.marvelcharacters.domain.CharacterService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListViewModel(
    private val service: CharacterService,
    private val gateway: CharacterGateway
): ScreenModel {
//    suspend fun getCharacters(): List<Character> =
//        service.getListCharacters()

    val getList = MutableStateFlow(emptyList<Character>())
    val _getListFiltered = MutableStateFlow(emptyList<Character>())
    val filteredProducts = _getListFiltered.asStateFlow()
//    var offset = 0
//    var limit = 30


    init {
        screenModelScope.launch(Dispatchers.Main) {
            val list = getCharacters()
            getList.value = list
            _getListFiltered.value = list
        }
    }


    fun searchProducts(text: String) {
        screenModelScope.launch{
            _getListFiltered.value = if (text.isEmpty()) {
                getList.value
            } else {
                getList.value.filter {
                    it.name.orEmpty().contains(
                        text,
                        ignoreCase = true
                    )
                }
            }
        }
    }

    suspend fun getCharacters(): List<Character> {
        val response = service.getListCharacters()
        return response
    }

    private var isLoading = false

    suspend fun loadNextPage(charactersState: MutableState<List<Character>>) {
        // Evita múltiplas chamadas simultâneas
        if (isLoading) return

        isLoading = true
        try {
            val offset = charactersState.value.size
            val limit = 20 // ou o valor desejado
            val newCharacters = getCharacters()
            charactersState.value += newCharacters
        } catch (e: Exception) {
            // Trate os erros de requisição, se necessário
        } finally {
            isLoading = false
        }
    }
}
