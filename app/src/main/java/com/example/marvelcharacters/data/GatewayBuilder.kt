package com.example.marvelcharacters.data

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory

//object GatewayBuilder {
//
//    private const val BASE_URL = "https://gateway.marvel.com/"
//    private val contentType = "application/json".toMediaType()
//
//    @OptIn(ExperimentalSerializationApi::class)
//    private val json = Json {
//        ignoreUnknownKeys = true
//        explicitNulls = false
//    }
//
//    private val client = OkHttpClient.Builder()
//        .addInterceptor(MarvelInterceptor())
//        .build()
//
//    @OptIn(ExperimentalSerializationApi::class)
//    val retrofit: Retrofit by lazy {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .client(client)
//            .addConverterFactory(json.asConverterFactory(contentType))
//            .build()
//    }
//
//    inline fun <reified T> build(): T =
//        retrofit.create(T::class.java)
//}