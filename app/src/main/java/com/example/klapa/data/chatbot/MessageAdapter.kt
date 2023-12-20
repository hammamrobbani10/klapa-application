package com.example.klapa.data.chatbot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.klapa.R

class MessageAdapter(private val messages: MutableList<MessageModel>) :
    RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val layoutResId = when (viewType) {
            MessageModel.BOT_MESSAGE_TYPE -> R.layout.message_item
            MessageModel.USER_MESSAGE_TYPE -> R.layout.message_item
            else -> throw IllegalArgumentException("Invalid viewType")
        }

        val view: View = LayoutInflater.from(parent.context)
            .inflate(layoutResId, parent, false)

        return if (viewType == MessageModel.BOT_MESSAGE_TYPE) {
            BotMessageViewHolder(view)
        } else {
            UserMessageViewHolder(view)
        }
    }


    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val messageViewHolder = holder
        messageViewHolder.bind(messages[position])
    }

    override fun getItemViewType(position: Int): Int {
        return if (messages[position].isBot) MessageModel.BOT_MESSAGE_TYPE else MessageModel.USER_MESSAGE_TYPE
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    fun addMessage(message: MessageModel) {
        messages.add(message)
        notifyItemInserted(messages.size - 1)
    }

    open class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        open fun bind(messageModel: MessageModel) {
            // Do nothing by default
        }
    }

    class UserMessageViewHolder(itemView: View) : MessageViewHolder(itemView) {
        private val userMessageTextView: TextView = itemView.findViewById(R.id.tv_message)

        override fun bind(messageModel: MessageModel) {
            userMessageTextView.text = messageModel.message
            userMessageTextView.visibility = View.VISIBLE
        }
    }

    class BotMessageViewHolder(itemView: View) : MessageViewHolder(itemView) {
        private val botMessageTextView: TextView = itemView.findViewById(R.id.tv_bot_message)
        private val userMessageTextView: TextView = itemView.findViewById(R.id.tv_message)

        override fun bind(messageModel: MessageModel) {
            if (messageModel.isBot) {
                botMessageTextView.text = messageModel.message
                botMessageTextView.visibility = View.VISIBLE
                userMessageTextView.visibility = View.GONE
            } else {
                userMessageTextView.text = messageModel.message
                userMessageTextView.visibility = View.VISIBLE
                botMessageTextView.visibility = View.GONE
            }
        }
    }



}