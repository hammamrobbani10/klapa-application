package com.example.klapa.data.chatbot

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.klapa.R
import kotlinx.coroutines.*

class ChatBotActivity : AppCompatActivity() {

    private lateinit var etMessage: EditText
    private lateinit var btnSend: Button
    private lateinit var rvMessages: RecyclerView
    private lateinit var messageAdapter: MessageAdapter
    private val messages = mutableListOf<MessageModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_bot)

        etMessage = findViewById(R.id.et_message)
        btnSend = findViewById(R.id.btn_send)
        rvMessages = findViewById(R.id.rv_messages)

        messageAdapter = MessageAdapter(messages)
        rvMessages.adapter = messageAdapter

        val layoutManager = LinearLayoutManager(this)
        rvMessages.layoutManager = layoutManager

        btnSend.setOnClickListener {
            sendMessage()
        }
    }

    private var lastUserMessage: String = ""

    private fun sendMessage() {
        val userMessage = etMessage.text.toString().trim()

        // User message
        val userMessageModel = MessageModel(userMessage, false)
        if (userMessageModel.message.isNotBlank()){
            messageAdapter.addMessage(userMessageModel)
        }
        //messageAdapter.addMessage(userMessageModel)

        // Check if the user message is the same as the previous one
        if (userMessage.isNotBlank()) {
            // Bot reply (you need to implement the logic to generate bot replies)
            val botReply = generateBotReply(userMessage)

            // Add bot reply only if it's not blank
            if (botReply.isNotBlank()) {
                val botReplyModel = MessageModel(botReply, true)
                messageAdapter.addMessage(botReplyModel)
            }

            // Update the last user message
            lastUserMessage = userMessage
        }

        // Clear the input field
        etMessage.text.clear()

        // Scroll to the last message
        rvMessages.smoothScrollToPosition(messageAdapter.itemCount - 1)
    }

    private fun generateBotReply(userMessage: String): String {
        return when {
            userMessage.contains("hi", ignoreCase = true) -> "Bot: Hi there! What can I help you with?"
            userMessage.contains("how are you", ignoreCase = true) -> "Bot: I'm just a bot, but thanks for asking!"
            // Tambahkan logika respons tambahan sesuai kebutuhan
            else -> "Bot: Thank you for your message!"
        }
    }


}
