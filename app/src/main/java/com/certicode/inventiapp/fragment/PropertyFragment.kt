package com.certicode.inventiapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.HorizontalScrollView
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

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvAgents)
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

        // Dummy data
        val agents = listOf(
            AgentModel(R.drawable.tompogi, "Tom Oliver Chua", "Licensed Broker"),
            AgentModel(R.drawable.tompogi, "Jane Doe", "Real Estate Agent"),
            AgentModel(R.drawable.tompogi, "John Smith", "Property Consultant")
        )


        rvPropertyItem.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvPropertyItem.adapter = PropertyAdapter(propertyAmmenities)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = AgentAdapter(agents)

        // Hide Top Layout
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.GONE

        // Hide Bottom Nav
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Restore search bar & bottom nav when leaving this fragment
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.VISIBLE
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.VISIBLE
    }
}
