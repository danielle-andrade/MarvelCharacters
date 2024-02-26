package com.example.marvelcharacters.data

import com.example.marvelcharacters.data.Constants.timestamp
import okhttp3.Interceptor
import okhttp3.Response
/**
 * Interceptors are a powerful mechanism that can monitor, rewrite, and retry calls.
 * são uma classe especial do Retrofit responsáveis por interceptar os requests e adicionar headers e
 * query params de forma automática, para todos os requests.
 * */
class MarvelInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newUrl =
            chain.request().url.newBuilder()
                .addQueryParameter("apikey", Constants.PUBLIC_KEY)
                .addQueryParameter("ts", timestamp)
                .addQueryParameter("hash", Constants.hash())
                .build()

        val newRequest = chain.request().newBuilder().url(newUrl).build()

        return chain.proceed(newRequest)
    }
}