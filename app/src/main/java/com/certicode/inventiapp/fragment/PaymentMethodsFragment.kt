package com.certicode.inventiapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.certicode.inventiapp.R
import androidx.navigation.fragment.findNavController
import com.certicode.inventiapp.databinding.FragmentPaymentMethodsBinding

class PaymentMethodsFragment: Fragment() {

    private  var _binding: FragmentPaymentMethodsBinding? = null
    private val binding get() = _binding!!

    private var selectedRadioButton: RadioButton? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPaymentMethodsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        // Set up click listeners for each payment option layout
        binding.paymentOption1Layout.setOnClickListener {
            selectRadioButton(binding.paymentOption1Radio)
        }
        binding.paymentOption2Layout.setOnClickListener {
            selectRadioButton(binding.paymentOption2Radio)
        }
        binding.paymentOption3Layout.setOnClickListener {
            selectRadioButton(binding.paymentOption3Radio)
        }
        binding.paymentOption4Layout.setOnClickListener {
            selectRadioButton(binding.paymentOption4Radio)
        }

        binding.addPaymentMethod.setOnClickListener {
            findNavController().navigate(R.id.action_paymentMethodsFragment_to_addCardFragment)
        }

        // Also handle clicks on the radio buttons themselves
        binding.paymentOption1Radio.setOnClickListener {
            selectRadioButton(binding.paymentOption1Radio)
        }
        binding.paymentOption2Radio.setOnClickListener {
            selectRadioButton(binding.paymentOption2Radio)
        }
        binding.paymentOption3Radio.setOnClickListener {
            selectRadioButton(binding.paymentOption3Radio)
        }
        binding.paymentOption4Radio.setOnClickListener {
            selectRadioButton(binding.paymentOption4Radio)
        }
    }

    private fun selectRadioButton(radioButton: RadioButton) {
        selectedRadioButton?.isChecked = false // Uncheck previously selected
        radioButton.isChecked = true // Check the new one
        selectedRadioButton = radioButton // Update selected
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.VISIBLE

    }
}