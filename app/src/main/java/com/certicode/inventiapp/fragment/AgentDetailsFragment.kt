package com.certicode.inventiapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.certicode.inventiapp.R


class AgentDetailsFragment : Fragment() {

    private lateinit var imagePlaceHolder: ImageView
    private lateinit var agentName: TextView
    private lateinit var agentProfession: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_agent_details, container, false)

        imagePlaceHolder = view.findViewById<ImageView>(R.id.imagePlaceHolder)
        agentName = view.findViewById<TextView>(R.id.agentName)
        agentProfession = view.findViewById<TextView>(R.id.agentProfession)

        arguments?.let {
            bundle ->
            val imageRes = bundle.getInt("image")
            val name = bundle.getString("name")
            val profession = bundle.getString("profession")


            imagePlaceHolder.setImageResource(imageRes)
            agentName.text = name
            agentProfession.text = profession
        }

        return view
    }


}