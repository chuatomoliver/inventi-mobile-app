package com.certicode.inventiapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.certicode.inventiapp.R
import com.certicode.inventiapp.adapter.AgentAdapter
import com.certicode.inventiapp.adapter.AmenityAdapter
import com.certicode.inventiapp.databinding.FragmentAmenitiesBinding
import com.certicode.inventiapp.models.AgentModel
import com.certicode.inventiapp.models.AmenitiesModel

class AmenitiesFragment : Fragment() {

    private var _binding: FragmentAmenitiesBinding? = null
    private val binding get() = _binding!!

    private lateinit var amenityAdapter: AmenityAdapter
    private lateinit var amenitiesList: List<AmenitiesModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAmenitiesBinding.inflate(inflater, container, false)

        binding.rvAmenities.layoutManager = LinearLayoutManager(requireContext())

        amenitiesList = listOf(
            AmenitiesModel(
                R.drawable.basketball_court,
                600,
                5010.0,
                4.5,
                "Woodland, Pasay City",
                "Sports Amenities",
                "Basketball Court",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
            ),
            AmenitiesModel(
                R.drawable.tennis_bg,
                320,
                2000.0,
                4.2,
                "Green Park, Makati",
                "Community Facility",
                "Tennis Court",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
            ),
            AmenitiesModel(
                R.drawable.pool_bg,
                320,
                2000.0,
                4.2,
                "Green Park, Makati",
                "Community Facility",
                "Swimming Pool",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
            ),
            // ... keep the rest of your dummy list here
        )

        // Hide Top Layout
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.GONE
        // Hide Bottom Nav
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE

        amenityAdapter = AmenityAdapter(amenitiesList) { selectedAmenity ->
            val fragment = BookAmenityFragment.newInstance(selectedAmenity)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        binding.rvAmenities.adapter = amenityAdapter


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

        // Restore visibility when leaving fragment
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.VISIBLE
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.VISIBLE
    }

}
