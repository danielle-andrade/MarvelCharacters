package com.example.marvelcharacters

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.marvelcharacters.data.CharacterGateway
import com.example.marvelcharacters.domain.Character

//class PagingSource(
//    private val marvelApi: CharacterGateway,
//) : PagingSource<Int, Character>() {
//    override fun getRefreshKey(
//        state: PagingState<Int, Character>
//    ): Int? {
//        return state.anchorPosition?.let { anchorPosition ->
//            val anchorPage = state.closestPageToPosition(
//                anchorPosition
//            )
//            anchorPage?.prevKey?.plus(1) ?:
//            anchorPage?.nextKey?.minus(1)
//        }
//    }
//
//    override suspend fun load(
//        params: LoadParams<Int>
//    ): LoadResult<Int, Character> {
//        return try {
//            val page = params.key ?: 0
//            val offset = page * PAGE_SIZE
//            val response = marvelApi.getCharacters(offset = offset)
//            val nextKey =
//                if (offset >= response.data.total) null
//                else page + 1
//            return LoadResult.Page(
//                data = response.data.results.map { it.toDomainChar() },
//                prevKey = null, // Only paging forward.
//                nextKey = nextKey
//            )
//        } catch (e: Exception) {
//            LoadResult.Error(e)
//        }
//    }
//
//    companion object {
//        const val PAGE_SIZE = 20
//    }
//}
