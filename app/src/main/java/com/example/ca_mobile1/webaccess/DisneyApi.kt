package com.example.ca_mobile1.webaccess

import com.example.ca_mobile1.data.Disney
import com.example.ca_mobile1.data.DisneyResponse
import retrofit2.http.GET

interface DisneyApi {
    @GET("characters")
    suspend fun getCharacters() : DisneyResponse
}