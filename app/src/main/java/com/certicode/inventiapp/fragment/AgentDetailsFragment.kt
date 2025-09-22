package com.certicode.inventiapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.certicode.inventiapp.R
import com.certicode.inventiapp.databinding.FragmentAgentDetailsBinding
import com.certicode.inventiapp.models.AgentListModel

class AgentDetailsFragment : Fragment() {

    private var _binding: FragmentAgentDetailsBinding? = null
    private val binding get() = _binding!!

    private var agents: AgentListModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAgentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rating.setOnClickListener {
            val fragment = AgentRatingFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }
        agentFetchDetails()
    }

    private fun agentFetchDetails() {
        agents = arguments?.getParcelable(ARG_AGENTS)
        agents?.let { agent ->
            binding.imagePlaceHolder.setImageResource(agent.imagePlaceHolder)
            binding.agentName.text = agent.agentName
            binding.agentProfession.text = agent.agentProfession
            binding.description.text = agent.description
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_AGENTS = "agents"

        fun newInstance(agents: AgentListModel): AgentDetailsFragment {
            val fragment = AgentDetailsFragment()
            val bundle = Bundle().apply {
                putParcelable(ARG_AGENTS, agents)
            }
            fragment.arguments = bundle
            return fragment
        }
    }
}
