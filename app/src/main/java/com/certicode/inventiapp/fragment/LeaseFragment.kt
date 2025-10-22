package com.certicode.inventiapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.certicode.inventiapp.R
import com.certicode.inventiapp.adapter.LeaseAdapter
import com.certicode.inventiapp.databinding.FragmentLeaseBinding
import com.certicode.inventiapp.models.LeaseItem

class LeaseFragment : Fragment() {

    private var _binding: FragmentLeaseBinding? = null
    private val binding get() = _binding!!

    private lateinit var leaseAdapter: LeaseAdapter
    private val leaseList = mutableListOf<LeaseItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLeaseBinding.inflate(inflater, container, false)

        setupRecyclerView()
        loadSampleData()

        return binding.root
    }

    private fun setupRecyclerView() {
        leaseAdapter = LeaseAdapter(leaseList)
        binding.recyclerViewLease.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = leaseAdapter
        }
    }

    private fun loadSampleData() {
        leaseList.add(
            LeaseItem(
                "Live Lease",
                "Make renters fall in love with your building—before they ever visit.",
                R.drawable.building_layout
            )
        )
        leaseList.add(
            LeaseItem(
                "Prime Property",
                "Discover premium properties available for leasing now.",
                R.drawable.building_layout
            )
        )
        leaseList.add(
            LeaseItem(
                "Live Lease",
                "Make renters fall in love with your building—before they ever visit.",
                R.drawable.building_layout
            )
        )
        leaseList.add(
            LeaseItem(
                "Prime Property",
                "Discover premium properties available for leasing now.",
                R.drawable.building_layout
            )
        )
        leaseList.add(
            LeaseItem(
                "Live Lease",
                "Make renters fall in love with your building—before they ever visit.",
                R.drawable.building_layout
            )
        )
        leaseList.add(
            LeaseItem(
                "Prime Property",
                "Discover premium properties available for leasing now.",
                R.drawable.building_layout
            )
        )
        leaseAdapter.notifyDataSetChanged()

        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.GONE

    }


    override fun onDestroyView() {
        super.onDestroyView()
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.VISIBLE
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.VISIBLE
    }

}
