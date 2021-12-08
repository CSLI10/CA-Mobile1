package com.example.ca_mobile1.webaccess

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        Retrofit.Builder()
            .baseUrl("https://api.disneyapi.dev/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(httpClient.build())
            .build()
    }

    val api: DisneyApi by lazy {
        retrofit.create(DisneyApi::class.java)
    }
}