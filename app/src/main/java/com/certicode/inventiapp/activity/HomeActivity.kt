package com.certicode.inventiapp.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.certicode.inventiapp.R
import com.certicode.inventiapp.adapter.FeatureAdapter
import com.certicode.inventiapp.databinding.ActivityHomeBinding
import com.certicode.inventiapp.models.FeatureModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // --- Navigation Component Setup ---
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

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
                }
            }
        }

        
    }
}
