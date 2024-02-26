package com.example.marvelcharacters.data

import com.example.marvelcharacters.domain.Character
import com.example.marvelcharacters.domain.CharacterService
/**
 * implementa a interface do Service retornando o gateway
 * */

class CharacterRepository(
    private val gateway: CharacterGateway,
) : CharacterService {

    override suspend fun getCharacter(id: Int): Character {
        val response = gateway.getCharacter(id)
        return response.data.results.first().toDomainChar()
    }

    override suspend fun getListCharacters(): List<Character> {
        val response = gateway.getCharacters()
        return response.data.toDomain().characters
    }
}




