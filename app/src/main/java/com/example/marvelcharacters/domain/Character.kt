package com.example.marvelcharacters.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
//
data class ListCharacter(
    val characters: List<Character>
)
data class Character(
    val id: Int,
    val name: String?,
    val description: String?,
)
