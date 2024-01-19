package com.example.marvelcharacters

import com.example.marvelcharacters.data.CharacterGateway
import com.example.marvelcharacters.data.CharacterService
import com.example.marvelcharacters.data.MarvelInterceptor
import com.example.marvelcharacters.userInterface.detail.DetailViewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.bindSingleton
import org.kodein.di.instance
import org.kodein.di.provider
import retrofit2.Retrofit

object AppInjection {
    private const val MODULE_NAME = "app"

    val injections = DI.Module(MODULE_NAME) {
        val contentType = "application/json".toMediaType()
        val parser: Json by lazy {
            Json {
                allowSpecialFloatingPointValues = true
                coerceInputValues = true
                encodeDefaults = true
                ignoreUnknownKeys = true
                isLenient = true
            }
        }

        bindSingleton {
            OkHttpClient.Builder()
                .addInterceptor(MarvelInterceptor())
                .build()
        }

        bindSingleton {
            Retrofit.Builder().baseUrl("https://gateway.marvel.com/")
                .client(instance())
                .addConverterFactory(
                    parser
                        .asConverterFactory(contentType)
                )
                .build()
        }

        bindSingleton {
            val retrofit: Retrofit = instance()
            retrofit.create(CharacterGateway::class.java)
        }

        bindSingleton{
            val gat: CharacterGateway = instance()
        }

        bindSingleton<CharacterService> {
            CharacterService()
        }

        bind<DetailViewModel>() with provider {
            DetailViewModel(
                service = instance(),
            )
        }
    }
}