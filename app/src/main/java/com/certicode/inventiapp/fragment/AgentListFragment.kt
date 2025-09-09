package com.certicode.inventiapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.certicode.inventiapp.R
import com.certicode.inventiapp.adapter.AgentListAdapter
import com.certicode.inventiapp.models.AgentListModel

class AgentListFragment : Fragment() {

    private lateinit var rvAgentList: RecyclerView
    private lateinit var agentListAdapter: AgentListAdapter
    private lateinit var agentListModel: List<AgentListModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_agent_list, container, false)

        agentList(view)
        rvAgentList = view.findViewById<RecyclerView>(R.id.rvAgentList)
        agentListAdapter = AgentListAdapter(agentListModel) { agent ->
            val fragment = AgentDetailsFragment.newInstance(agent) // Conected to Companion Object AgentDetailsFragment

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        rvAgentList.layoutManager = LinearLayoutManager(requireContext())
        rvAgentList.adapter = agentListAdapter



        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.GONE
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE

        return view
    }

    private fun agentList(view: View){
        agentListModel = listOf(

            AgentListModel(R.drawable.tompogi,
                "Tom Bond",
                "Care Broker",
                "Tom Oliver Chua is a licensed broker, fully authorized to facilitate and manage real estate transactions with professionalism and integrity"
            ),
            AgentListModel(R.drawable.tompogi,
                "John Bond",
                "Care Giver",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
            ),
            AgentListModel(R.drawable.tompogi,
                "James Bond",
                "License Broker",
                "Tom Oliver Chua is a licensed broker, fully authorized to facilitate and manage real estate transactions with professionalism and integrity"
            ),
            AgentListModel(R.drawable.tompogi,
                "Rud Bond",
                "Jungle",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
            ),
        )
    }
    override fun onDestroy() {
        super.onDestroy()
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.VISIBLE
        // Hide Bottom Nav
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.VISIBLE

    }

}