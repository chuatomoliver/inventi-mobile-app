package com.certicode.inventiapp.Gemini_Integration

import com.google.gson.annotations.SerializedName

data class AskRequest(
    val prompt: String
)

// ⚠️ Change "message" to the actual key from the API response!
data class AskResponse(
    @SerializedName("response")
    val reply: String
)