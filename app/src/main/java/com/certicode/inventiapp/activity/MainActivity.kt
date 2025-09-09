package com.certicode.inventiapp.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.certicode.inventiapp.R
import com.certicode.inventiapp.databinding.ActivityHomeBinding
import com.certicode.inventiapp.databinding.ActivityMainBinding
import com.certicode.inventiapp.fragment.SignUpFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Sign In button click listener
        binding.signInButton.setOnClickListener {
            // Navigate to HomeActivity after sign in
            val intent = Intent(this, Home2Activity::class.java)
            startActivity(intent)
        }

        // Sign Up text click listener - Navigate to SignUpFragment
        binding.signUpText.setOnClickListener {
            navigateToFragment(SignUpFragment())
        }

        binding.fingerprintIconCard.setOnClickListener {
            // Handle biometric authentication
            handleBiometricAuthentication()
        }
    }

    private fun navigateToFragment(fragment: Fragment) {
        // Show the fragment container and hide the login form
        binding.fragmentContainer.visibility = android.view.View.VISIBLE
        binding.loginContainer.visibility = android.view.View.GONE

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }



    private fun handleBiometricAuthentication() {
        // For now, just navigate to home as a placeholder
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}