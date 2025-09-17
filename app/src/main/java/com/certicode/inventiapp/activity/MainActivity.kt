package com.certicode.inventiapp.activity

<<<<<<< HEAD
import HomeFragment
import android.annotation.SuppressLint
=======
>>>>>>> origin/ui_paymnent_method
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
            // For now, just navigate to home as a placeholder
            val intent = Intent(this, Home2Activity::class.java)
            startActivity(intent)
        }

        // Sign Up text click listener
        binding.signUpText.setOnClickListener {
<<<<<<< HEAD
=======
            // For now, just navigate to home as a placeholder
>>>>>>> origin/ui_paymnent_method
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