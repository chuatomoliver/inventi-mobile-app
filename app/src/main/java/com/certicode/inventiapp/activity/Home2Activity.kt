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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHome2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load default fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }

        // Handle bottom nav clicks
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.homeFragment -> HomeFragment()
                R.id.mapsFragment -> MapsFragment()
                R.id.catFragment -> CatFragment()
                R.id.leaseFragment -> BuildingLayoutFragment()
                R.id.profileFragment -> ProfileFragment()
                else -> null
            }
            fragment?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, it)
                    .commit()
            }
            true
        }
    }
}
