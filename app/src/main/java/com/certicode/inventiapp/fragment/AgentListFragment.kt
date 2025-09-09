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
            val fragment = AgentDetailsFragment()

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
                "James Bond",
                "License Broker"
            ),
            AgentListModel(R.drawable.tompogi,
                "Natasha Romanoff",
                "Care Giver"
            ),
            AgentListModel(R.drawable.tompogi,
                "Ethan Hunt",
                "VIP Agent"
            ),
            AgentListModel(R.drawable.tompogi,
                "James Bond",
                "License Broker"
            ),
            AgentListModel(
                R.drawable.tompogi,
                "Natasha Romanoff",
                "Care Giver"
            ),
            AgentListModel(
                R.drawable.tompogi,
                "Ethan Hunt",
                "VIP Agent"
            ),
            AgentListModel(R.drawable.tompogi,
                "James Bond",
                "License Broker"
            ),
            AgentListModel(
                R.drawable.tompogi,
                "Natasha Romanoff",
                "Care Giver"
            ),
            AgentListModel(
                R.drawable.tompogi,
                "Ethan Hunt",
                "VIP Agent"
            ),
            AgentListModel(
                R.drawable.tompogi,
                "James Bond",
                "License Broker"
            ),
            AgentListModel(
                R.drawable.tompogi,
                "Natasha Romanoff",
                "Care Giver"
            ),
            AgentListModel(
                R.drawable.tompogi,
                "Ethan Hunt",
                "VIP Agent"
            )
        )
    }
    override fun onDestroy() {
        super.onDestroy()
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.VISIBLE
        // Hide Bottom Nav
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.VISIBLE

    }

}