package com.certicode.inventiapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.certicode.inventiapp.R
import com.certicode.inventiapp.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.backButton.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.paymentMethodRow.setOnClickListener {
            val fragment = PaymentMethodsFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        binding.editProfileRow.setOnClickListener {
            val fragment = EditProfileFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        binding.completeProfileButton.setOnClickListener {
            val fragment = CompleteProfileFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onResume() {
        super.onResume()

        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.GONE
        // Hide Bottom Nav
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE

    }

    override fun onDestroy() {
        super.onDestroy()
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.VISIBLE
        // Hide Bottom Nav
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.VISIBLE

    }

}