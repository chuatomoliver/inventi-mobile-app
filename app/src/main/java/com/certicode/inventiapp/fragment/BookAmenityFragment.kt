package com.certicode.inventiapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.certicode.inventiapp.R
import com.certicode.inventiapp.adapter.AgentAdapter
import com.certicode.inventiapp.databinding.FragmentBookAmenityBinding
import com.certicode.inventiapp.models.AgentModel
import com.certicode.inventiapp.models.AmenitiesModel

class BookAmenityFragment : Fragment() {

    private var _binding: FragmentBookAmenityBinding? = null
    private val binding get() = _binding!!

    private var amenity: AmenitiesModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookAmenityBinding.inflate(inflater, container, false)
        amenity = arguments?.getParcelable(ARG_AMENITY)

        uiSetup()
        dummyDataAgents()

        return binding.root
    }

    private fun dummyDataAgents() {
        val agents = listOf(
            AgentModel(R.drawable.tompogi, "Tom Oliver Chua", "Licensed Broker"),
            AgentModel(R.drawable.tompogi, "Jane Doe", "Real Estate Agent"),
            AgentModel(R.drawable.tompogi, "John Smith", "Property Consultant")
        )

        binding.rvAgentList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAgentList.adapter = AgentAdapter(agents)
    }

    private fun uiSetup() {
        amenity?.let { a ->
            binding.imagePlaceHolder.setImageResource(a.imagePlaceHolder)
            binding.amenitiesTitle.text = a.amenitiesTitle
            binding.locationText.text = a.location
            binding.ratingText.text = a.rating.toString()
            binding.amenityReviews.text = "(${a.reviews} reviews)"
            binding.amenityTag.text = a.tagAmenity
            binding.description.text = a.description
            binding.amenityFee.text = "$${a.amenityFee}"
        }
    }

    companion object {
        private const val ARG_AMENITY = "amenity"

        fun newInstance(amenity: AmenitiesModel): BookAmenityFragment {
            val fragment = BookAmenityFragment()
            val bundle = Bundle().apply {
                putParcelable(ARG_AMENITY, amenity)
            }
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onResume() {
        super.onResume()
        // Hide when this fragment is visible
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.GONE
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        // Restore UI when leaving
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.GONE
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE
    }
}
