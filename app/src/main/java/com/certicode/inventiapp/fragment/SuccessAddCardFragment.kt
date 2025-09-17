package com.certicode.inventiapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.certicode.inventiapp.R
import com.certicode.inventiapp.databinding.FragmentSuccessAddCardBinding

class SuccessAddCardFragment : Fragment() {

    private var _binding: FragmentSuccessAddCardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuccessAddCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewReceiptButton.setOnClickListener {
            findNavController().navigate(R.id.action_successAddCardFragment_to_profileFragment)
        }

        binding.goToHomeButton.setOnClickListener {
            findNavController().navigate(R.id.action_successAddCardFragment_to_homeFragment)
        }

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}