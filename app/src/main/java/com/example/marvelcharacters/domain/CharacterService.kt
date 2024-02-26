package com.example.marvelcharacters.domain

/**
 * define o contrato que será usado no Repository
 * */


interface CharacterService {

    suspend fun getListCharacters(): List<Character>
    suspend fun getCharacter(id: Int): Character

}