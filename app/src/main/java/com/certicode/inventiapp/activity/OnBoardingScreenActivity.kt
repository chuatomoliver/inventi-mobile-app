package com.certicode.inventiapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.certicode.inventiapp.databinding.ActivityOnBoardingScreenBinding
import com.certicode.inventiapp.fragment.OnBoardingScreenFragment1
import com.certicode.inventiapp.R
import com.certicode.inventiapp.fragment.OnBoardingScreenFragment2
import com.certicode.inventiapp.fragment.OnBoardingScreenFragment3

class OnBoardingScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingScreenBinding
    private var currentStep = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnBoardingScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load onboarding fragment only once
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.boardingScreenContainer, OnBoardingScreenFragment1())
                .commit()
        }

        binding.nxtBtn.setOnClickListener {
            when (currentStep) {
                1 -> {
                    loadFragment(OnBoardingScreenFragment2())
                    currentStep = 2
                }

                2 -> {
                    loadFragment(OnBoardingScreenFragment3())
                    currentStep = 3
                }

                3 -> {
                    // Save preference so onboarding won't show again
                    val prefs = getSharedPreferences("app_prefs", MODE_PRIVATE)
                    prefs.edit().putBoolean("onboarding_shown", true).apply()

                    // Go to MainActivity
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }
        }
    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.boardingScreenContainer, fragment)
            .commit()
    }
}
