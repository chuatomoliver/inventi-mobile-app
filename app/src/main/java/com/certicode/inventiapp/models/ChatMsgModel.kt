package com.certicode.inventiapp.models;

data class ChatMsgModel (
    val text: String,
    val isUser: Boolean,
    val name: String,
    val avatarRes: Int // drawable resource for avatar
)
