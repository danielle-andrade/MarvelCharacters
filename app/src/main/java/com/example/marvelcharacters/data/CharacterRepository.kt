package com.example.marvelcharacters.data


import CharacterMapper
import com.example.marvelcharacters.domain.Character
import com.example.marvelcharacters.domain.CharacterService

class CharacterRepository(
    private val gateway: CharacterGateway,
) : CharacterService {
//    override suspend fun getCharacter(id: Int): CharacterData {
//        return gateway.getCharacter(id).let { CharacterMapper.toDomainData(it) }
//
//        //return gateway.getCharacter(id).let { CharacterMapper.toDomain(it)}
//    }

    //    override suspend fun getListCharacters(): List<Character> {
//        return gateway.getCharacters().results.map { CharacterMapper.toDomain(it) }
//    }
//    override suspend fun getListCharacters(): CharacterResponse {
//        return gateway.getCharacters()
//    }

//    override suspend fun getCharacter2(id: Int): Character {
//        return gateway.getCharacter(id).let { CharacterMapper.toDomainChar(it) }
//    }

    override suspend fun getCharacter2(id: Int): Character {
        val response = gateway.getCharacter(id)
        return response.
    }




//    override suspend fun getListCharacters2(): List<Character> {
//        return gateway.getCharacters().data.results.map { CharacterResponse. }
//    }

        override suspend fun getListCharacters2(): List<Character> {
          val response = gateway.getCharacters()
            return response.data.toDomain().characters
    }
}
