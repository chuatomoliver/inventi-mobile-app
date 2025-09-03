package com.certicode.inventiapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.certicode.inventiapp.databinding.FragmentPaymentMethodsBinding
import com.certicode.inventiapp.databinding.FragmentProfileBinding

class PaymentMethodsFragment: Fragment() {

    private  var _binding: FragmentPaymentMethodsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPaymentMethodsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


}