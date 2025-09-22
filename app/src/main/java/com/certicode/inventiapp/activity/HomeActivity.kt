@file:JvmName("HomeActivityKt")

package com.certicode.inventiapp.activity

import HomeFragment
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.certicode.inventiapp.R
import com.certicode.inventiapp.databinding.ActivityHome2Binding
import com.certicode.inventiapp.fragment.CatFragment

import com.certicode.inventiapp.fragment.MapsFragment
import com.certicode.inventiapp.fragment.ProfileHostFragment
import com.certicode.inventiapp.fragment.ProfileNavListener

private val fragments = arrayOf(
    HomeFragment(),
    MapsFragment(),
    CatFragment(),
    ProfileHostFragment()
)

class Home2Activity : AppCompatActivity(), ProfileNavListener {

    private lateinit var binding: ActivityHome2Binding
    private var activeFragmentIndex = 0




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
        val fragmentToShow = fragments[position]
        supportFragmentManager.beginTransaction().apply {
            // Hide the currently active fragment
            hide(fragments[activeFragmentIndex])
            // Show the newly selected fragment
            show(fragmentToShow)
            commit()
        }
        activeFragmentIndex = position

        // If we are showing a fragment that is not the profile host, ensure the navigation UI is visible.
        if (fragmentToShow !is ProfileHostFragment) {
            binding.actionbarSearch.visibility = View.VISIBLE
            binding.bottomNavigation.visibility = View.VISIBLE
        }
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
            imageView.isSelected = i == selectedPosition
        }
    }

    override fun onProfileDestinationChanged(destinationId: Int) {
        when (destinationId) {
            R.id.editProfileFragment,
            R.id.completeProfileFragment,
            R.id.paymentMethodsFragment,
            R.id.successAddCardFragment,
            R.id.addCardFragment,
            R.id.viewEReceiptFragment -> {
                binding.actionbarSearch.visibility = View.GONE
                binding.bottomNavigation.visibility = View.GONE
            }
            else -> {
                binding.actionbarSearch.visibility = View.VISIBLE
                binding.bottomNavigation.visibility = View.VISIBLE
            }
        }
    }
}