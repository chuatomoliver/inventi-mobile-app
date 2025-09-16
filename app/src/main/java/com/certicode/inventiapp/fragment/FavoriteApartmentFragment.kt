package com.certicode.inventiapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.certicode.inventiapp.R
import com.certicode.inventiapp.adapter.FavoriteAdapter
import com.certicode.inventiapp.models.FavoriteModel


class FavoriteApartmentFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var favoriteAdapter: FavoriteAdapter
    private lateinit var favoriteList: MutableList<FavoriteModel>

    private lateinit var allProperty: Button
    private lateinit var sortHouses: Button
    private lateinit var sortVilla: Button
    private lateinit var sortApartments: Button

    private var selectedType: String = "All" // default selection

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_favorite_apartment, container, false)

        onClickFilter(view)
        favItemList(view)
        filterList("All")

        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.GONE
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE

        return  view
    }

    private fun onClickFilter(view: View){
        // Buttons
        allProperty = view.findViewById(R.id.allProperty)
        sortHouses = view.findViewById(R.id.sortHouses)
        sortVilla = view.findViewById(R.id.sortVilla)
        sortApartments = view.findViewById(R.id.sortApartments)

        allProperty.setOnClickListener { filterList("All") }
        sortHouses.setOnClickListener { filterList("House") }
        sortVilla.setOnClickListener { filterList("Villa") }
        sortApartments.setOnClickListener { filterList("Apartment") }
    }
    private fun favItemList(view: View){

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        favoriteList = mutableListOf(

            FavoriteModel(
                R.drawable.apartment,
                "Apartment", 4.5,
                "Cozy Apartment",
                "Manila",
                25000,
                "month",
                "Apartment"
            ),

            FavoriteModel(
                R.drawable.apartment,
                "Villa", 4.8,
                "Luxury Villa",
                "Tagaytay",
                100000,
                "month",
                "Villa"
            ),

            FavoriteModel(
                R.drawable.apartment,
                "House",
                4.2,
                "Family House",
                "Quezon City",
                50000,
                "month",
                "House"
            ),

            FavoriteModel(
                R.drawable.apartment,
                "House",
                4.2, "Family House",
                "Quezon City",
                50000,
                "month", "House"
            ),
            FavoriteModel(
                R.drawable.apartment,
                "House",
                4.2,
                "Family House",
                "Quezon City",
                50000,
                "month",
                "House"
            ),
        )

        favoriteAdapter = FavoriteAdapter(favoriteList) { favorite ->
            // Handle item click here, e.g., show BottomSheetDialog
            val bottomSheet = FavoriteRemoveDialogFragment.newInstance(favorite)
            bottomSheet.show(parentFragmentManager, "RemoveFavoriteDialog")
        }

        recyclerView.adapter = favoriteAdapter

    }

    private fun filterList(type: String) {

        selectedType = type

        // Reset button colors
        resetButtonColors()

        // Highlight selected button
        when(selectedType) {
            "All" -> {
                allProperty.setBackgroundColor(resources.getColor(R.color.blue1))
                allProperty.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            }
            "House" -> {
                sortHouses.setBackgroundColor(resources.getColor(R.color.blue1))
                sortHouses.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            }
            "Villa" -> {
                sortVilla.setBackgroundColor(resources.getColor(R.color.blue1))
                sortVilla.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            }
            "Apartment" -> {
                sortApartments.setBackgroundColor(resources.getColor(R.color.blue1))
                sortApartments.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            }
        }

        // Filter the list
        val filteredList = if(selectedType.equals("All", ignoreCase = true)) {
            favoriteList
        } else {
            favoriteList.filter { it.type.equals(type, ignoreCase = true) }
        }

        favoriteAdapter.updateList(filteredList)
    }

    private fun resetButtonColors() {
        val defaultColor = resources.getColor(R.color.gray) // same as your #E7E7E7
        allProperty.setBackgroundColor(defaultColor)
        sortHouses.setBackgroundColor(defaultColor)
        sortVilla.setBackgroundColor(defaultColor)
        sortApartments.setBackgroundColor(defaultColor)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Restore search bar & bottom nav when leaving this fragment
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.VISIBLE
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.VISIBLE
    }
}