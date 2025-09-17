package com.certicode.inventiapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.certicode.inventiapp.fragment.BirdFragment
import com.certicode.inventiapp.fragment.CatFragment
import com.certicode.inventiapp.fragment.HomeFragment
import com.certicode.inventiapp.fragment.MapsFragment


private const val NUM_TABS = 4

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    // Store the fragments in a list to ensure consistency
    private val fragments = listOf(
        HomeFragment(),
        MapsFragment(),
        CatFragment(),
        BirdFragment()
    )

    override fun getItemCount(): Int {
        // Return the size of the fragments list directly
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        // Get the fragment from the list based on the position
        return fragments[position]
    }
}