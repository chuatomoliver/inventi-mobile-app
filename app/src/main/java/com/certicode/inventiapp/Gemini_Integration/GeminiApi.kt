package com.certicode.inventiapp.Gemini_Integration

import com.certicode.inventiapp.Gemini_Integration.AskRequest
import com.certicode.inventiapp.Gemini_Integration.AskResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface GeminiApi {
    @POST("ask")
    fun ask(@Body request: AskRequest): Call<AskResponse>
}