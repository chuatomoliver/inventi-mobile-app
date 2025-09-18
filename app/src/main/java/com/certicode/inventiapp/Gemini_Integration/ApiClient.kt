package com.certicode.inventiapp.network

import com.certicode.inventiapp.Gemini_Integration.GeminiApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    // ⚠️ Replace with the real base URL of your hosted API
    private const val BASE_URL = "https://certicode-condo.tmc-innovations.com/api/"

    val gemini: GeminiApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GeminiApi::class.java)
    }
}
