package com.certicode.inventiapp.activity

import HomeFragment
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.certicode.inventiapp.R
import com.certicode.inventiapp.databinding.ActivityHome2Binding
import com.certicode.inventiapp.fragment.*
private val fragments = arrayOf(
    HomeFragment(),
    MapsFragment(),
    CatFragment(),
    BirdFragment()
)

class Home2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityHome2Binding
    private var activeFragmentIndex = 0

    private val unselectedIcons = arrayOf(
        R.drawable.ic_home,
        R.drawable.ic_search,
        R.drawable.ic_location,
        R.drawable.ic_profile2
    )

    private val selectedIcons = arrayOf(
        R.drawable.ic_home_selected,
        R.drawable.ic_search,
        R.drawable.ic_location,
        R.drawable.ic_profile2
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHome2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the LinearLayout tabs to control the fragments
        val iconViews = listOf(
            findViewById<ImageView>(R.id.ic_home),
            findViewById<ImageView>(R.id.searchButton),
            findViewById<ImageView>(R.id.mailButton),
            findViewById<ImageView>(R.id.settingsButton)
        )

        // Set up the initial fragment
        supportFragmentManager.beginTransaction().apply {
            // Add all fragments initially but hide all except the first
            for (fragment in fragments) {
                add(R.id.fragment_container, fragment, fragment.javaClass.simpleName)
                hide(fragment)
            }
            show(fragments[0])
            commit()
        }

        // Set up click listeners for the navigation icons
        for (i in iconViews.indices) {
            val imageView = iconViews[i]
            imageView.setOnClickListener {
                // When a tab is clicked, show the corresponding fragment
                showFragment(i)
                // Update the icon state
                updateTabSelection(i)
            }
        }

        // Initialize the first tab as selected
        updateTabSelection(0)
    }

    /**
     * Helper function to show the selected fragment and hide all others.
     */
    private fun showFragment(position: Int) {
        supportFragmentManager.beginTransaction().apply {
            // Hide the currently active fragment
            hide(fragments[activeFragmentIndex])
            // Show the newly selected fragment
            show(fragments[position])
            commit()
        }
        activeFragmentIndex = position
    }

    /**
     * Helper function to handle the selection state of the tabs.
     * It updates the icon of the selected tab and deselects others.
     */
    private fun updateTabSelection(selectedPosition: Int) {
        val iconViews = listOf(
            findViewById<ImageView>(R.id.ic_home),
            findViewById<ImageView>(R.id.searchButton),
            findViewById<ImageView>(R.id.mailButton),
            findViewById<ImageView>(R.id.settingsButton)
        )

        for (i in iconViews.indices) {
            val imageView = iconViews[i]
            if (i == selectedPosition) {
                // Set the selected tab's icon to the selected drawable
                imageView.setImageResource(selectedIcons[i])
            } else {
                // Set the unselected tabs' icons to the unselected drawable
                imageView.setImageResource(unselectedIcons[i])
            }
        }
    }

}