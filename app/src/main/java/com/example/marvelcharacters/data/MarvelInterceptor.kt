package com.example.marvelcharacters.data

import com.example.marvelcharacters.data.Constants.timestamp
import okhttp3.Interceptor
import okhttp3.Response

val constants = Constants
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