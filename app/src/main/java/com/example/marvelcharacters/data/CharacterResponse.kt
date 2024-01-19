package com.example.marvelcharacters.data

import kotlinx.serialization.Serializable


@Serializable
data class CharactersResponse(
    val characters: List<CharacterResponse> = emptyList()

)

@Serializable
data class CharacterResponse(
    val id: Int,
    val name: String,
    val description: String


    //val description: null,
    //val parameters: String? = null
)
