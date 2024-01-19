package com.example.marvelcharacters.data

import CharacterMapper
import com.example.marvelcharacters.domain.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterService {

    private val gateway by lazy {
        GatewayBuilder.build<CharacterGateway>()
    }

//    suspend fun getCharacters(): List<Character> =
//        withContext(Dispatchers.IO) {
//            gateway
//                .getCharacters()
//                .characters
//                .map (CharacterMapper::toDomain)
//        }

    suspend fun getCharacter(id: Int): Character =
        gateway.getCharacter(id)
            .let (CharacterMapper::toDomain)
}