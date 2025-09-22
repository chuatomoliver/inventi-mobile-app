package com.certicode.inventiapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.certicode.inventiapp.R
import com.certicode.inventiapp.adapter.AgentAdapter
import com.certicode.inventiapp.adapter.PropertyAdapter
import com.certicode.inventiapp.databinding.FragmentPropertyBinding
import com.certicode.inventiapp.models.AgentModel
import com.certicode.inventiapp.models.PropertyModel

class PropertyFragment : Fragment() {

    private var _binding: FragmentPropertyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPropertyBinding.inflate(inflater, container, false)

        dummyDataAgents()
        dummyDataAmmenities()

        binding.reviews.setOnClickListener {
            val fragment = ApartmentRatingFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }
        binding.bookApartmentBtn.setOnClickListener {
            val fragment = ReviewSummaryFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        // Hide Top Layout
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.GONE

        // Hide Bottom Nav
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE

        return binding.root
    }

    private fun dummyDataAmmenities() {
        val propertyAmmenities = listOf(
            PropertyModel(R.drawable.apartment),
            PropertyModel(R.drawable.apartment),
            PropertyModel(R.drawable.apartment),
            PropertyModel(R.drawable.apartment),
            PropertyModel(R.drawable.apartment),
            PropertyModel(R.drawable.apartment),
            PropertyModel(R.drawable.apartment),
            PropertyModel(R.drawable.apartment),
        )

        binding.rvPropertyItem.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvPropertyItem.adapter = PropertyAdapter(propertyAmmenities)
    }

    private fun dummyDataAgents() {
        val agents = listOf(
            AgentModel(R.drawable.tompogi, "Tom Oliver Chua", "Licensed Broker"),
            AgentModel(R.drawable.tompogi, "Jane Doe", "Real Estate Agent"),
            AgentModel(R.drawable.tompogi, "John Smith", "Property Consultant")
        )

        binding.rvAgents.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAgents.adapter = AgentAdapter(agents)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clear binding reference
        _binding = null

        // Restore search bar & bottom nav when leaving this fragment
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.VISIBLE
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.VISIBLE
    }
}
