package com.certicode.inventiapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.certicode.inventiapp.R
import com.certicode.inventiapp.adapter.ChatAdapter
import com.certicode.inventiapp.databinding.FragmentChatBotBinding
import com.certicode.inventiapp.models.ChatMsgModel

class ChatBotFragment : Fragment() {

    private var _binding: FragmentChatBotBinding? = null
    private val binding get() = _binding!!

    private val messages = mutableListOf<ChatMsgModel>()
    private lateinit var chatAdapter: ChatAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatBotBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        chatAdapter = ChatAdapter(messages)
        binding.rvChatMsgOutput.layoutManager = LinearLayoutManager(requireContext())
        binding.rvChatMsgOutput.adapter = chatAdapter

        // Hide Top Layout
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.GONE
        // Hide Bottom Nav
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE

        binding.sentMsg.setOnClickListener {
            chatMsg()
            binding.linearOfferBox.visibility = View.GONE
        }
    }

    private fun chatMsg() {
        val text = binding.inputMsg.text.toString()
        if (text.isNotEmpty()) {
            messages.add(ChatMsgModel(text, true, "You", R.drawable.tompogi))
            chatAdapter.notifyItemInserted(messages.size - 1)
            binding.rvChatMsgOutput.scrollToPosition(messages.size - 1)
            binding.inputMsg.text.clear()

            // Add bot reply (for testing)
            messages.add(ChatMsgModel("Hello, I am a bot! Your msg is: $text", false, "Gemini", R.drawable.tompogi))
            chatAdapter.notifyItemInserted(messages.size - 1)
            binding.rvChatMsgOutput.scrollToPosition(messages.size - 1)
            binding.inputMsg.text.clear()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Avoid memory leaks
        _binding = null

        // Restore visibility when leaving fragment
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.VISIBLE
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.VISIBLE
    }
}
