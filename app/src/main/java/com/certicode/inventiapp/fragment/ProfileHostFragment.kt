package com.certicode.inventiapp.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.certicode.inventiapp.R

interface ProfileNavListener {
    fun onProfileDestinationChanged(destinationId: Int)
}

class ProfileHostFragment : Fragment() {

    private var listener: ProfileNavListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ProfileNavListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement ProfileNavListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile_host, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment = childFragmentManager.findFragmentById(R.id.profile_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, destination, _ ->
            listener?.onProfileDestinationChanged(destination.id)
        }
    }

    override fun onResume() {
        super.onResume()
        // Manually trigger for the current destination when the fragment becomes visible
        val navHostFragment = childFragmentManager.findFragmentById(R.id.profile_nav_host_fragment) as NavHostFragment
        listener?.onProfileDestinationChanged(navHostFragment.navController.currentDestination!!.id)
    }


    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}