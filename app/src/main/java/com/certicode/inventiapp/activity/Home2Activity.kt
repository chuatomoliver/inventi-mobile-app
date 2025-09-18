package com.certicode.inventiapp.activity

import HomeFragment
import android.os.Bundle
import android.view.MenuItem
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

        binding.bottomNavigation.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.nav_home -> showFragment(0)
                R.id.nav_maps -> showFragment(1)
                R.id.nav_cat -> showFragment(2)
                R.id.nav_bird -> showFragment(3)
            }
            true
        }



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
        // Initialize the first tab as selected

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


}