package com.certicode.inventiapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.certicode.inventiapp.R
import com.certicode.inventiapp.databinding.FragmentAgentRatingBinding
import com.certicode.inventiapp.databinding.FragmentApartmentRatingsBinding

class ApartmentRatingFragment : Fragment() {

    private var _binding: FragmentApartmentRatingsBinding? = null
    private val binding get() = _binding!!  // safe accessor

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentApartmentRatingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onResume() {
        super.onResume()

        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.GONE
        // Hide Bottom Nav
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE

    }

    override fun onDestroy() {
        super.onDestroy()
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.GONE
        // Hide Bottom Nav
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE

    }
}
