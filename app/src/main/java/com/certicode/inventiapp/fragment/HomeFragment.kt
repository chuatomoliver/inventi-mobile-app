import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.certicode.inventiapp.R
import com.certicode.inventiapp.adapter.ApartmentAdapter
import com.certicode.inventiapp.adapter.FeatureAdapter
import com.certicode.inventiapp.databinding.FragmentCatBinding
import com.certicode.inventiapp.databinding.FragmentHomeBinding
import com.certicode.inventiapp.fragment.AgentListFragment

import com.certicode.inventiapp.fragment.AmenitiesFragment
import com.certicode.inventiapp.fragment.BookingListFragment
import com.certicode.inventiapp.fragment.ChatBotFragment
import com.certicode.inventiapp.fragment.LeaseFragment

import com.certicode.inventiapp.fragment.PropertyFragment

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

        binding.tvViewAll.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AgentListFragment()) // make sure this matches your container id
                .addToBackStack(null)
                .commit()
        }

        val rvFeatures = binding.rvFeatures
        rvFeatures.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvFeatures.adapter = FeatureAdapter(featureList) { feature, position ->
            when(feature.featureName) {
                "Chat bot" -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ChatBotFragment()) // make sure this matches your container id
                        .addToBackStack(null)
                        .commit()
                }
                "Ammenities" -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, AmenitiesFragment())
                        .addToBackStack(null)
                        .commit()
                }

                "Lease" -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, LeaseFragment())
                        .addToBackStack(null)
                        .commit()
                }

                "Hoa" -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, BookingListFragment())
                        .addToBackStack(null)
                        .commit()
                }
            }
        }


        rvFeatures.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                super.getItemOffsets(outRect, view, parent, state)

                val position = parent.getChildAdapterPosition(view)
                val itemCount = parent.adapter?.itemCount ?: 0
                val margin = 10 // Define your desired margin here

                if (position == 0) {
                    // This is the first item
                    outRect.left = margin
                } else if (position == itemCount - 1) {
                    // This is the last item
                    outRect.right = margin
                }

                // Apply a margin between all items (optional)
                outRect.right = outRect.right + 18
            }
        })

        val rvApartment = binding.rvAparment
        rvApartment.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvApartment.adapter = ApartmentAdapter(
            apartmentList,
            { apartment ->
                val fragment = PropertyFragment()

                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit()

            },
            parentFragmentManager
        )

        rvApartment.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                super.getItemOffsets(outRect, view, parent, state)

                val position = parent.getChildAdapterPosition(view)
                val itemCount = parent.adapter?.itemCount ?: 0
                val margin = 10 // Define your desired margin here

                if (position == 0) {
                    // This is the first item
                    outRect.left = margin
                } else if (position == itemCount - 1) {
                    // This is the last item
                    outRect.right = margin
                }

                // Apply a margin between all items (optional)
                outRect.right = outRect.right + 18
            }
        })

        return view
    }

}

val featureList = listOf(
    FeatureModel(
        featureLogo = R.drawable.feature_1,
        featureName = "Home",
    ),
    FeatureModel(
        featureLogo = R.drawable.feature_2,
        featureName = "Ammenities",
    ),
    FeatureModel(
        featureLogo = R.drawable.feature_3,
        featureName = "Hoa",
    ),

    FeatureModel(
        featureLogo = R.drawable.building,
        featureName = "Lease",
    ),

    FeatureModel(
        featureLogo = R.drawable.feature_4,
        featureName = "Chat bot",
    ),
)

val  apartmentList = listOf(
    ApartmentModel(
        imageResource = R.drawable.apartment,
        title = "Cityland Apartments",
        location = "Pasig City",
        rating = 4.5,
        price = 1500
    ),
    ApartmentModel(
        imageResource = R.drawable.apartment,
        title = "Ayala Makati Lofts",
        location = "Makati, NCR",
        rating = 4.8,
        price = 2500
    ),
    ApartmentModel(
        imageResource = R.drawable.apartment,
        title = "SMDC Condomium",
        location = "Mandaluyong, Edsa",
        rating = 4.2,
        price = 1800
    ),
    ApartmentModel(
        imageResource = R.drawable.apartment,
        title = "Deca Homes",
        location = "Ortigas, Pasig",
        rating = 4.6,
        price = 1750
    ),
    ApartmentModel(
        imageResource = R.drawable.apartment,
        title = "Double Dragon",
        location = "Pasay City",
        rating = 4.9,
        price = 2200
    )


)