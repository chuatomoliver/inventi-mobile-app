package com.certicode.inventiapp.fragment

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.certicode.inventiapp.R
import com.certicode.inventiapp.adapter.ApartmentAdapter
import com.certicode.inventiapp.adapter.FeatureAdapter
import com.certicode.inventiapp.databinding.FragmentHomeBinding
import com.certicode.inventiapp.models.ApartmentModel
import com.certicode.inventiapp.models.FeatureModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        // === Features RecyclerView ===
        val rvFeatures = binding.rvFeatures
        rvFeatures.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvFeatures.adapter = FeatureAdapter(featureList) { feature, _ ->
            val navController = findNavController()
            when (feature.featureName) {
                "Chat bot" -> navController.navigate(R.id.chatBotFragment)
                "Hospital" -> navController.navigate(R.id.hospitalFragment)
                "Check-up" -> navController.navigate(R.id.checkupFragment)
                "Emergency" -> navController.navigate(R.id.emergencyFragment)
                "Community" -> navController.navigate(R.id.communityFragment)
                "Maps" -> navController.navigate(R.id.mapsFragment)
                "Profile" -> navController.navigate(R.id.profileFragment)
                "Payments" -> navController.navigate(R.id.paymentMethodsFragment)
                "Property" -> navController.navigate(R.id.propertyFragment)
                "Reviews" -> navController.navigate(R.id.reviewSummaryFragment)
                "Bookings" -> navController.navigate(R.id.bookingListFragment)
                "Favorites" -> navController.navigate(R.id.favoriteApartmentFragment)
                "Agents" -> navController.navigate(R.id.agentListFragment)
                "Amenities" -> navController.navigate(R.id.amenitiesFragment)
            }
        }
        rvFeatures.addItemDecoration(horizontalSpacingDecoration())

        // === Apartments RecyclerView ===
        val rvAparment = binding.rvAparment
        rvAparment.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvAparment.adapter = ApartmentAdapter(apartmentList, { apartment ->
            // TODO: handle apartment item click (navigate to details if needed)
        }, childFragmentManager)
        rvAparment.addItemDecoration(horizontalSpacingDecoration())

        return view
    }

    private fun horizontalSpacingDecoration(): RecyclerView.ItemDecoration {
        return object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                super.getItemOffsets(outRect, view, parent, state)
                val position = parent.getChildAdapterPosition(view)
                val itemCount = parent.adapter?.itemCount ?: 0
                val margin = 10

                if (position == 0) {
                    outRect.left = margin
                } else if (position == itemCount - 1) {
                    outRect.right = margin
                }
                outRect.right = outRect.right + 18
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

// === Features List ===
val featureList = listOf(
    FeatureModel("Hospital"),
    FeatureModel("Check-up"),
    FeatureModel("Emergency"),
    FeatureModel("Chat bot"),
    FeatureModel("Maps"),
    FeatureModel("Profile"),
    FeatureModel("Payments"),
    FeatureModel("Property"),
    FeatureModel("Reviews"),
    FeatureModel("Bookings"),
    FeatureModel("Favorites"),
    FeatureModel("Agents"),
    FeatureModel("Amenities")
)

// === Apartments List ===
val apartmentList = listOf(
    ApartmentModel(R.drawable.apartment, "Cityland Apartments", "Pasig City", 4.5, 1500),
    ApartmentModel(R.drawable.apartment, "Ayala Makati Lofts", "Makati, NCR", 4.8, 2500),
    ApartmentModel(R.drawable.apartment, "SMDC Condominium", "Mandaluyong, Edsa", 4.2, 1800),
    ApartmentModel(R.drawable.apartment, "Deca Homes", "Ortigas, Pasig", 4.6, 1750),
    ApartmentModel(R.drawable.apartment, "Double Dragon", "Pasay City", 4.9, 2200)
)
