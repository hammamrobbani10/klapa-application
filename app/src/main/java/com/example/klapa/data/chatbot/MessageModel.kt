package com.example.klapa.data.chatbot

data class MessageModel(val message: String, val isBot: Boolean) {
    companion object {
        const val USER_MESSAGE_TYPE = 0
        const val BOT_MESSAGE_TYPE = 1
    }
}

