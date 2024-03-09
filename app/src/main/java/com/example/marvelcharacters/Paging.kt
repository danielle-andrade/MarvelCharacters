package com.example.marvelcharacters

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.marvelcharacters.domain.CharacterService

//class Paging (
//    private val characterRepository: CharacterService,
//    private val query: String
//) : PagingSource<Int, com.example.marvelcharacters.domain.Character>() {
//
//    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
//        return state.anchorPosition?.let { anchorPosition ->
//            val anchorPage = state.closestPageToPosition(anchorPosition)
//            anchorPage?.prevKey?.plus(LIMIT) ?: anchorPage?.nextKey?.minus(LIMIT)
//        }
//    }
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, com.example.marvelcharacters.domain.Character> {
//        return try {
//            val offset = params.key ?: 0
//
//            val queries = hashMapOf(
//                "offset" to offset.toString()
//            )
//
//            if (query.isNotEmpty()) {
//                queries["nameStartsWith"] = query
//            }
//
//            val response = characterRepository.getListCharacters(queries).data
//
//            val responseOffset = response.offset
//            val totalCharacters = response.total
//
//            LoadResult.Page(
//                data = response.results.map { it.toCharacterModel() },
//                prevKey = null,
//                nextKey = if (responseOffset < totalCharacters) {
//                    responseOffset + LIMIT
//                } else null
//            )
//        } catch (exception: Exception) {
//            LoadResult.Error(exception)
//        }
//    }
//
//    companion object {
//        private const val LIMIT = 20
//    }
//}