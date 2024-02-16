package com.example.marvelcharacters.domain

import com.example.marvelcharacters.data.CharacterData

interface CharacterService {

    suspend fun getListCharacters(): List<Character>

    suspend fun getCharacter(id: Int): CharacterData


}