package com.example.marvelcharacters.data

import com.example.marvelcharacters.domain.Character
import com.example.marvelcharacters.domain.ListCharacter
import kotlinx.serialization.Serializable


@Serializable
data class CharacterResponse(
    val data: CharacterData
)
@Serializable
data class CharacterData(
    val results: List<CharResponse>
) {
    fun toDomain() = ListCharacter(
        characters = results.map { it.toDomainChar() }
    )
}

@Serializable
data class CharResponse(
    val id: Int,
    val name: String,
    val description: String,
) { fun toDomainChar() =
    Character(
        id = id,
        name = name,
        description = description
    )
}

