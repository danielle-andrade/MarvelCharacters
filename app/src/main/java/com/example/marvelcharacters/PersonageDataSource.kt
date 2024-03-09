package com.example.marvelcharacters

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.marvelcharacters.data.CharacterGateway
import com.example.marvelcharacters.data.OneCharacterResponse
import com.example.marvelcharacters.userInterface.list.ListViewModel
import java.io.IOException

//class PersonageDataSource(
//        private val api: CharacterGateway
//    ) : PagingSource<Int, OneCharacterResponse>() {
//        @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
//        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, OneCharacterResponse> {
//            return try {
//                val result = api.getCharacters(params.key ?: STARTING_PAGE_INDEX).data
//                LoadResult.Page(
//                    data = result.results,
//                    prevKey = params.key,
//                    nextKey = params.key?.plus(1) ?: STARTING_PAGE_INDEX.plus(1)
//                )
//            } catch (e: IOException) {
//                LoadResult.Error(e)
//            } catch (e: HttpException) {
//                LoadResult.Error(e)
//            }
//        }
//
//        companion object {
//            private const val STARTING_PAGE_INDEX = 1
//        }
//
//    override fun getRefreshKey(state: PagingState<Int, OneCharacterResponse>): Int? {
//        TODO("Not yet implemented")
//    }
//}
