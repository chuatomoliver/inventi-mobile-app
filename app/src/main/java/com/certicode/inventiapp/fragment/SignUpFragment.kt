package com.certicode.inventiapp.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.certicode.inventiapp.activity.HomeActivity
import com.certicode.inventiapp.activity.MainActivity
import com.certicode.inventiapp.databinding.ActivityMainBinding
import com.certicode.inventiapp.databinding.FragmentSignupBinding

class SignUpFragment: Fragment() {


    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Sign Up button click listener
        binding.signInText.setOnClickListener {
            // Navigate to HomeActivity after sign up
            val intent = Intent(requireActivity(), MainActivity::class.java)
            startActivity(intent)
        }

        binding.signUpButton.setOnClickListener {
            val intent = Intent(requireActivity(), MainActivity::class.java)
            startActivity(intent)
        }
  }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}