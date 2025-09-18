package com.certicode.inventiapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.certicode.inventiapp.Gemini_Integration.AskRequest
import com.certicode.inventiapp.Gemini_Integration.AskResponse
import com.certicode.inventiapp.R
import com.certicode.inventiapp.adapter.ChatAdapter
import com.certicode.inventiapp.databinding.FragmentChatBotBinding
import com.certicode.inventiapp.models.ChatMsgModel
import com.certicode.inventiapp.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        // Hide Top and Bottom Nav if needed
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.GONE
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE

        binding.sentMsg.setOnClickListener {
            sendMessage()
            binding.linearOfferBox.visibility = View.GONE
        }
    }

    private fun sendMessage() {
        val text = binding.inputMsg.text.toString().trim()
        if (text.isEmpty()) return

        // Display user message immediately
        messages.add(ChatMsgModel(text, true, "You", R.drawable.tompogi))
        chatAdapter.notifyItemInserted(messages.size - 1)
        binding.rvChatMsgOutput.scrollToPosition(messages.size - 1)
        binding.inputMsg.text.clear()

        // Prepare and send request
        val request = AskRequest(prompt = text)
        ApiClient.gemini.ask(request).enqueue(object : Callback<AskResponse> {
            override fun onResponse(call: Call<AskResponse>, response: Response<AskResponse>) {
                if (response.isSuccessful) {
                    val reply = response.body()?.reply ?: "No reply field in response."
                    addBotReply(reply)
                    Log.d("API_BODY", "Success: ${response.body()}")
                } else {
                    val errorText = response.errorBody()?.string() ?: "Unknown error"
                    addBotReply("Error ${response.code()}: $errorText")
                    Log.e("API_ERROR", errorText)
                }
            }

            override fun onFailure(call: Call<AskResponse>, t: Throwable) {
                addBotReply("Network error: ${t.localizedMessage}")
                Log.e("API_FAIL", t.stackTraceToString())
            }
        })
    }

    private fun addBotReply(reply: String) {
        messages.add(ChatMsgModel(reply, false, "Gemini", R.drawable.tompogi))
        chatAdapter.notifyItemInserted(messages.size - 1)
        binding.rvChatMsgOutput.scrollToPosition(messages.size - 1)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.VISIBLE
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.VISIBLE
    }
}
