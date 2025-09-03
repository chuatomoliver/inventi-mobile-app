package com.certicode.inventiapp.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.certicode.inventiapp.R
import com.certicode.inventiapp.activity.MainActivity
import com.certicode.inventiapp.databinding.FragmentOtpBinding

class OtpFragment: Fragment() {

    private var _binding: FragmentOtpBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOtpBinding.inflate(inflater, container, false)
        val view = binding.root



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Sign Up button click listener
        binding.continueMainActivity.setOnClickListener {
            val intent = Intent(requireActivity(), MainActivity::class.java)
            startActivity(intent)
        }

        binding.backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

    }


}