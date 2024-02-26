package com.example.marvelcharacters.domain


interface CharacterService {

    suspend fun getListCharacters(): List<Character>
    suspend fun getCharacter(id: Int): Character

}