package com.certicode.inventiapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.certicode.inventiapp.R
import com.certicode.inventiapp.adapter.ChatAdapter
import com.certicode.inventiapp.models.ChatMsgModel

class ChatBotFragment : Fragment() {

    private lateinit var rvChatMsg: RecyclerView
    private lateinit var inputMsg: EditText
    private lateinit var sentMsgBtn: ImageView

    private val messages = mutableListOf<ChatMsgModel>()
    private lateinit var chatAdapter: ChatAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chat_bot, container, false)

        inputMsg = view.findViewById(R.id.inputMsg)
        sentMsgBtn = view.findViewById(R.id.sentMsg)
        rvChatMsg = view.findViewById(R.id.rvChatMsgOutput)

        chatAdapter = ChatAdapter(messages)
        rvChatMsg.layoutManager = LinearLayoutManager(requireContext())
        rvChatMsg.adapter = chatAdapter

        // Hide Top Layout
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.GONE
        // Hide Bottom Nav
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE

        sentMsgBtn.setOnClickListener {
          chatMsg();
        }

        return view
    }

    private fun chatMsg(){  val text = inputMsg.text.toString()
        if (text.isNotEmpty()) {
            messages.add(ChatMsgModel(text, true, "You", R.drawable.tompogi))
            chatAdapter.notifyItemInserted(messages.size - 1)
            rvChatMsg.scrollToPosition(messages.size - 1)
            inputMsg.text.clear()

            // Add bot reply (for testing)
            messages.add(ChatMsgModel("Hello, I am a bot! Your msg is: $text", false, "Gemini", R.drawable.tompogi))
            chatAdapter.notifyItemInserted(messages.size - 1)
            rvChatMsg.scrollToPosition(messages.size - 1)
            inputMsg.text.clear()
        }}


    override fun onDestroyView() {
        super.onDestroyView()

        // Restore visibility when leaving fragment
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.VISIBLE
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.VISIBLE
    }
}