package com.certicode.inventiapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.certicode.inventiapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Sign In button click listener
        binding.signInButton.setOnClickListener {
            // Navigate to HomeActivity after sign in
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        // Sign Up text click listener
        binding.signUpText.setOnClickListener {
            // For now, just navigate to home as a placeholder
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        binding.fingerprintIconCard.setOnClickListener {
            // Handle biometric authentication
            handleBiometricAuthentication()
        }
    }

    private fun handleBiometricAuthentication() {
        // For now, just navigate to home as a placeholder
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}