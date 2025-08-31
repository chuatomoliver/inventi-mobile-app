package com.certicode.inventiapp.activity

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.certicode.inventiapp.R
import com.certicode.inventiapp.adapter.ViewPagerAdapter
import com.certicode.inventiapp.databinding.ActivityMain2Binding

// Define your tab texts here
val animalsArray = arrayOf(
    "Cat",
    "Dog",
    "Bird"
)

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Find your views using view binding
        val viewPager = binding.viewPager
        val tabContainer = findViewById<LinearLayout>(R.id.tab_container) // Using findViewById as LinearLayout is not in the binding object by default

        // Set up the ViewPager2 adapter
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        // Sync the ViewPager2 to the LinearLayout tabs
        // This makes sure the tab highlights when you swipe the ViewPager
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateTabSelection(tabContainer, position)
            }
        })

        // Set up the LinearLayout tabs to control the ViewPager2
        for (i in 0 until tabContainer.childCount) {
            val textView = tabContainer.getChildAt(i) as TextView
            // Check if the TextView index is within the bounds of your data array
            if (i < animalsArray.size) {
                // Set the text of each TextView from the animalsArray
                textView.text = animalsArray[i]
                // Add a click listener to each TextView
                textView.setOnClickListener {
                    // When a tab is clicked, set the ViewPager's current item to match
                    viewPager.currentItem = i
                }
            }
        }

        // Initialize the first tab as selected when the activity starts
        updateTabSelection(tabContainer, 0)
    }

    /**
     * Helper function to handle the selection state of the tabs.
     * It updates the text color of the selected tab and deselects others.
     */
    private fun updateTabSelection(tabContainer: LinearLayout, selectedPosition: Int) {
        for (i in 0 until tabContainer.childCount) {
            val textView = tabContainer.getChildAt(i) as TextView

            if (i == selectedPosition) {
                // Set the selected tab's text color to white
                textView.setTextColor(ContextCompat.getColor(this, R.color.white))
            } else {
                // Set the unselected tabs' text color to blue
                textView.setTextColor(ContextCompat.getColor(this, R.color.blue1))
            }
        }
    }
}
