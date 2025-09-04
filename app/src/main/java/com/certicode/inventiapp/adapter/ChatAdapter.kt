package com.certicode.inventiapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.certicode.inventiapp.R
import com.certicode.inventiapp.models.ChatMsgModel

class ChatAdapter (
    private val messages: List<ChatMsgModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object{
        private const val VIEW_TYPE_USER = 1
        private const val VIEW_TYPE_BOT = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    : RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_USER){
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.user_chat_item, parent, false)
            UserViewHolder(view)
        } else{
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.bot_chat_item, parent, false)
            BotViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = messages[position]
        when(holder){
            is UserViewHolder -> holder.bind(chat)
            is BotViewHolder -> holder.bind(chat)
        }
    }
    override fun getItemViewType(position: Int): Int {
        return if (messages[position].isUser) {
            VIEW_TYPE_USER
        } else {
            VIEW_TYPE_BOT
        }
    }

    override fun getItemCount(): Int = messages.size

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val msgText: TextView = itemView.findViewById(R.id.userChatMsg)
        private val userName: TextView = itemView.findViewById(R.id.userName)
        private val avatar: ImageView = itemView.findViewById(R.id.imagePlaceHolder)

        fun bind (chat: ChatMsgModel){
            msgText.text = chat.text
            userName.text = chat.name
            avatar.setImageResource(chat.avatarRes)
        }
    }

    class BotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val msgText: TextView = itemView.findViewById(R.id.botChatMsg)
        private val botName: TextView = itemView.findViewById(R.id.botName)
        private val avatar: ImageView = itemView.findViewById(R.id.botImagePlaceHolder)

        fun bind(chat: ChatMsgModel){
            msgText.text = chat.text
            botName.text = chat.name
            avatar.setImageResource(chat.avatarRes)
        }
    }

}