package com.example.marvelcharacters.data


import CharacterMapper
import com.example.marvelcharacters.domain.Character
import com.example.marvelcharacters.domain.CharacterService

class CharacterRepository(
    private val gateway: CharacterGateway,
) : CharacterService {

    override suspend fun getCharacter(id: Int): CharacterData {
        return gateway.getCharacter(id).let { CharacterMapper.toDomainData(it) }
    }

    override suspend fun getListCharacters(): List<Character> {
        val response = gateway.getCharacters()
        return response.data.toDomain().characters
    }
}




