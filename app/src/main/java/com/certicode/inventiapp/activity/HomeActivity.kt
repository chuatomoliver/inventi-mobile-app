package com.certicode.inventiapp.activity

<<<<<<< HEAD
import HomeFragment
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
=======
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
>>>>>>> origin/ui_paymnent_method
import com.certicode.inventiapp.R
import com.certicode.inventiapp.adapter.FeatureAdapter
import com.certicode.inventiapp.databinding.ActivityHomeBinding
<<<<<<< HEAD

import com.certicode.inventiapp.fragment.ChatBotFragment
import com.certicode.inventiapp.models.FeatureModel


import com.certicode.inventiapp.fragment.*

// Define arrays for the unselected and selected icon drawables
val unselectedIcons = arrayOf(
    R.drawable.ic_home,
    R.drawable.ic_search,
    R.drawable.ic_location,
    R.drawable.ic_profile2
)

val selectedIcons = arrayOf(
    R.drawable.ic_home_selected,
    R.drawable.ic_search,
    R.drawable.ic_location,
    R.drawable.ic_profile2
)

private val fragments = arrayOf(
    HomeFragment(),
    MapsFragment(),
    CatFragment(),
    BirdFragment()
)
=======
>>>>>>> origin/ui_paymnent_method


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

<<<<<<< HEAD

        val featureList = listOf(
            FeatureModel(
                featureLogo = R.drawable.feature_1,
                featureName = "Hospital",
            ),
            FeatureModel(
                featureLogo = R.drawable.feature_2,
                featureName = "Community",
            ),
            FeatureModel(
                featureLogo = R.drawable.feature_3,
                featureName = "Check-up",
            ),
            FeatureModel(
                featureLogo = R.drawable.feature_4,
                featureName = "Emergency",
            ),
        )


        val rvFeatures = binding.rvFeatures
        rvFeatures.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvFeatures.adapter = FeatureAdapter(featureList) { feature, position ->
            when (feature.featureName) {
                "Chat bot" -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ChatBotFragment())
                        .addToBackStack(null)
                        .commit()
=======
        binding.bottomNavigation.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
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
>>>>>>> origin/ui_paymnent_method
                }
            }
        }


        rvFeatures.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.right = 18 // Adjust the right margin as needed


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
        })
    }
}