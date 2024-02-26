package com.example.marvelcharacters.data
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * interface onde é feita as requests pra API, retorna um CharacterResponse
 * */
interface CharacterGateway {

    @GET("/v1/public/characters")
    suspend fun getCharacters(
    ): CharacterResponse

    @GET("/v1/public/characters/{characterId}")
    suspend fun getCharacter(
        @Path("characterId") characterId: Int
    ): CharacterResponse
}
