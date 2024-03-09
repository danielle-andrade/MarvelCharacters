package com.example.marvelcharacters.domain

import com.example.marvelcharacters.data.CharacterData
import com.example.marvelcharacters.data.CharacterResponse

/**
 * define o contrato que será usado no Repository
 * */


interface CharacterService {

    suspend fun getListCharacters(): List<Character>
    suspend fun getCharacter(id: Int): Character

}