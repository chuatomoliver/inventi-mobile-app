package com.certicode.inventiapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.certicode.inventiapp.R
import com.certicode.inventiapp.models.AgentListModel


class AgentDetailsFragment : Fragment() {

    private var agents: AgentListModel? = null
    private lateinit var imagePlaceHolder: ImageView
    private lateinit var agentName: TextView
    private lateinit var agentProfession: TextView
    private lateinit var description: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_agent_details, container, false)

        imagePlaceHolder = view.findViewById<ImageView>(R.id.imagePlaceHolder)
        agentName = view.findViewById<TextView>(R.id.agentName)
        agentProfession = view.findViewById<TextView>(R.id.agentProfession)
        description = view.findViewById<TextView>(R.id.description)

        agents = arguments?.getParcelable(ARG_AGENTS)
        agents?.let { agent ->
            imagePlaceHolder.setImageResource(agent.imagePlaceHolder)
            agentName.text = agent.agentName
            agentProfession.text = agent.agentProfession
            description.text = agent.description
        }

        return view
    }

    companion object{
        private const val ARG_AGENTS = "agents"

        //Usage for AgentListFragment for parcalable item
        fun newInstance(agents: AgentListModel) : AgentDetailsFragment{
            val fragment = AgentDetailsFragment()

            val bundle = Bundle().apply {
                putParcelable(ARG_AGENTS, agents)

            }

            fragment.arguments = bundle
            return fragment
        }
    }

}