package com.tmcdigital.caregiver.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.certicode.inventiapp.adapter.OnboardingAdapter
import com.certicode.inventiapp.databinding.ActivityProfileBinding

import com.google.android.material.tabs.TabLayoutMediator



class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val introPager = binding.introViewPager // Replace with the actual ID of your ViewPager2

        val onboardingAdapter = OnboardingAdapter()
        introPager.adapter = onboardingAdapter

        TabLayoutMediator(binding.intoTabLayout, introPager) { tab, position -> }.attach() //The Magical Line

    }
}

