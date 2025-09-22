package com.certicode.inventiapp.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.certicode.inventiapp.activity.MainActivity
import com.certicode.inventiapp.databinding.FragmentOnBoardingScreenBinding

class OnBoardingScreenFragment1 : Fragment() {
    private  var _binding: FragmentOnBoardingScreenBinding? = null
    private val binding get() = _binding!! // ✅ ViewBinding reference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // ✅ Inflate layout with ViewBinding
        _binding = FragmentOnBoardingScreenBinding.inflate(inflater, container, false)


        return binding.root
    }
}