package com.example.marvelcharacters

interface Paginator<Key,Item> {
    suspend fun loadNextItems()
    fun reset()
}