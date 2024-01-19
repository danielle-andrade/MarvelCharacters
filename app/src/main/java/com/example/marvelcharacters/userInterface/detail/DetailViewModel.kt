package com.example.marvelcharacters.userInterface.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelcharacters.data.CharacterService
import com.example.marvelcharacters.domain.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel (
    private val service: CharacterService
) : ViewModel() {

   // private var service by Lazy: CharacterService

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val data = getCharacter(1)
            getPicture.value = data
        }
    }
    val getPicture: MutableState<Character?> = mutableStateOf(null)
    private suspend fun getCharacter(id: Int): Character =
        service.getCharacter(id)

//    object Factory {
//        fun build() =
//            object: ViewModelProvider.Factory {
//                override fun <T : ViewModel> create(modelClass: Class<T>): T =
//                    DetailViewModel(
//                        service = CharacterService()
//                    ) as T
//
//            }
//    }
}
