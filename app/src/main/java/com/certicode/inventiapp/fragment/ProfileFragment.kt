package com.certicode.inventiapp.fragment

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.certicode.inventiapp.R
import com.certicode.inventiapp.databinding.FragmentProfileBinding
import com.certicode.inventiapp.fragment.PaymentMethodsFragment


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


        binding.paymentMethodText.setOnClickListener {
            findNavController().navigate(R.id.navigation_payment_methods)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}