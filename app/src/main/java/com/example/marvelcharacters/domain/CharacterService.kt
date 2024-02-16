package com.example.marvelcharacters.domain

import com.example.marvelcharacters.data.CharacterData
import com.example.marvelcharacters.data.CharacterResponse

interface CharacterService {

    //   suspend fun getCharacter(id: Int): CharacterData

    suspend fun getListCharacters(): CharacterResponse


    suspend fun getListCharacters2(): List<Character>

    suspend fun getCharacter2(id: Int): Character


}