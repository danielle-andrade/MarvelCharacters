package com.example.marvelcharacters.domain



data class ListCharacter(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val characters: List<Character>
)
data class Character(
    val id: Int,
    val name: String?,
    val description: String?,
    val thumbnail: Thumbnail,
    )

data class Thumbnail(
    val path: String?,
    val extension: String?
) {
    val pathSec: String
        get() = path?.replace("http:", "https:").orEmpty()
}
