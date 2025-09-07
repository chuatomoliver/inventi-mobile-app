package com.certicode.inventiapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.certicode.inventiapp.R
import com.certicode.inventiapp.adapter.AmenityAdapter
import com.certicode.inventiapp.models.AmenitiesModel

class AmenitiesFragment : Fragment() {

    private lateinit var rvAmenity: RecyclerView
    private lateinit var amenityAdapter: AmenityAdapter
    private lateinit var amenitiesList: List<AmenitiesModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_amenities, container, false)

        rvAmenity = view.findViewById(R.id.rvAmenities)
        rvAmenity.layoutManager = LinearLayoutManager(requireContext())

        // Sample Data (replace with Firebase / API later if needed)
        amenitiesList = listOf(
            AmenitiesModel(
                R.drawable.basketball_court,
                600,
                5010.0,
                4.5,
                "Woodland, Pasay City",
                "Sports Amenities",
                "Basketball Court"
            ),
            AmenitiesModel(
                R.drawable.basketball_court,
                320,
                2000.0,
                4.2,
                "Green Park, Makati",
                "Community Facility",
                "Tennis Court"
            ),
                    AmenitiesModel(
                    R.drawable.basketball_court,
            320,
            2000.0,
            4.2,
            "Green Park, Makati",
            "Community Facility",
            "Tennis Court"
        ),
            AmenitiesModel(
                R.drawable.basketball_court,
                320,
                2000.0,
                4.2,
                "Green Park, Makati",
                "Community Facility",
                "Tennis Court"
            ),
            AmenitiesModel(
                R.drawable.basketball_court,
                320,
                2000.0,
                4.2,
                "Green Park, Makati",
                "Community Facility",
                "Tennis Court"
            ),
            AmenitiesModel(
                R.drawable.basketball_court,
                320,
                2000.0,
                4.2,
                "Green Park, Makati",
                "Community Facility",
                "Tennis Court"
            ),
            AmenitiesModel(
                R.drawable.basketball_court,
                320,
                2000.0,
                4.2,
                "Green Park, Makati",
                "Community Facility",
                "Tennis Court"
            ),
            AmenitiesModel(
                R.drawable.basketball_court,
                320,
                2000.0,
                4.2,
                "Green Park, Makati",
                "Community Facility",
                "Tennis Court"
            )

        )

        // Hide Top Layout
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.GONE
        // Hide Bottom Nav
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE
        amenityAdapter = AmenityAdapter(amenitiesList)
        rvAmenity.adapter = amenityAdapter
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()

        // Restore visibility when leaving fragment
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.VISIBLE
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.VISIBLE
    }

}