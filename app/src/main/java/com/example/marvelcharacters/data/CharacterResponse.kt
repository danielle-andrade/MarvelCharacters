package com.example.marvelcharacters.data


import com.example.marvelcharacters.domain.Character
import com.example.marvelcharacters.domain.ListCharacter
import com.example.marvelcharacters.domain.Thumbnail
import kotlinx.serialization.Serializable
/**
 * serializa de/para Json
 * */

@Serializable
data class CharacterResponse(
    val data: CharacterData
)
@Serializable
data class CharacterData(
    val results: List<OneCharacterResponse>
) {
    fun toDomain() = ListCharacter(
        characters = results.map { it.toDomainChar() }
    )
}

@Serializable
data class OneCharacterResponse(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: ThumbnailResponse,
) { fun toDomainChar() =
    Character(
        id = id,
        name = name,
        description = description,
        thumbnail = thumbnail.toDomain()
    )
}

@Serializable
data class ThumbnailResponse(
    val path: String?,
    val extension: String?,
) {
    val pathSec: String
        get() = path?.replace("http:", "https:").orEmpty()
    fun toDomain() =
        Thumbnail(
            path = path,
            extension = extension
        )
}
