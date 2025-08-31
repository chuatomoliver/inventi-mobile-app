package com.certicode.inventiapp.activity

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
import com.certicode.inventiapp.R
import com.certicode.inventiapp.databinding.ActivityHomeBinding
import com.certicode.inventiapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        spannableText()

        binding.signInButton.setOnClickListener {
            // This code block is executed when the button is clicked.

            // Example: Navigate to a new Activity
            // Replace 'HomeActivity::class.java' with the name of your target Activity.
            val intent = Intent(this, Home2Activity::class.java)
            startActivity(intent)
        }
    }

    fun spannableText(){
        val signUpTextView: TextView = findViewById(R.id.sign_up_text)
        val text = "Don't have an account? Sign Up"

// Create a SpannableString
        val spannable = SpannableString(text)

// Style the "Sign Up" part
        val signUpStart = text.indexOf("Sign Up")
        val signUpEnd = signUpStart + "Sign Up".length
        spannable.setSpan(StyleSpan(Typeface.BOLD), signUpStart, signUpEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannable.setSpan(ForegroundColorSpan(ContextCompat.getColor(this, R.color.lightbluebg)), signUpStart, signUpEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

// Apply the styled text to the TextView
        signUpTextView.text = spannable
    }


}