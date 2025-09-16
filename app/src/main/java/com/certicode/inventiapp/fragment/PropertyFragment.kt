package com.certicode.inventiapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.certicode.inventiapp.R
import com.certicode.inventiapp.adapter.AgentAdapter
import com.certicode.inventiapp.adapter.PropertyAdapter
import com.certicode.inventiapp.models.AgentModel
import com.certicode.inventiapp.models.PropertyModel

class PropertyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_property, container, false)

        dummyDataAgents(view)
        dummyDataAmmenities(view)

        val bookApartmentBtn = view.findViewById<Button>(R.id.bookApartmentBtn)

        bookApartmentBtn.setOnClickListener({

            val fragment = ReviewSummaryFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        })

        // Hide Top Layout
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.GONE

        // Hide Bottom Nav
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE
        return view
    }

    private fun dummyDataAmmenities(view: View){

        val rvPropertyItem = view.findViewById<RecyclerView>(R.id.rvPropertyItem)

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

        rvPropertyItem.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvPropertyItem.adapter = PropertyAdapter(propertyAmmenities)
    }

    private fun dummyDataAgents(view: View){

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvAgents)

        // Agent Dummy data
        val agents = listOf(
            AgentModel(R.drawable.tompogi,
                "Tom Oliver Chua",
                "Licensed Broker"),
            AgentModel(R.drawable.tompogi,
                "Jane Doe",
                "Real Estate Agent"),
            AgentModel(R.drawable.tompogi,
                "John Smith",
                "Property Consultant")
        )


        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = AgentAdapter(agents)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Restore search bar & bottom nav when leaving this fragment
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.VISIBLE
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.VISIBLE
    }
}
