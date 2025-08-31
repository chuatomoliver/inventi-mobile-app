package com.certicode.inventiapp.fragment

import android.location.Address
import android.location.Geocoder
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.certicode.inventiapp.R
import com.certicode.inventiapp.adapter.CustomInfoWindowAdapter
import com.certicode.inventiapp.databinding.FragmentMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import java.util.Locale

class MapsFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private var _binding: FragmentMapsBinding? = null
    private val binding get() = _binding!!

    private lateinit var googleMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMapsBinding.inflate(inflater, container, false)
        val view = binding.root

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

        binding.searchButton.setOnClickListener {
            searchLocation()
        }

        return view
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        googleMap.setInfoWindowAdapter(CustomInfoWindowAdapter(requireContext()))
        googleMap.uiSettings.isZoomControlsEnabled = true
        googleMap.uiSettings.isZoomGesturesEnabled = true
        googleMap.setOnInfoWindowClickListener(this) // Set the click listener here

        // Add a default marker in a specific location and move the camera
        val inventiLocation = LatLng(14.579954749820809, 121.04592810603383)
        googleMap.addMarker(MarkerOptions().position(inventiLocation).title("Marker in Inventi Office"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(inventiLocation))

        val cameraPosition = CameraPosition.Builder()
            .target(inventiLocation)
            .zoom(16f)
            .build()

        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
    }

    private fun searchLocation() {
        val locationName = binding.searchEditText.text.toString().trim()
        if (locationName.isEmpty()) {
            Toast.makeText(requireContext(), "Please enter a location", Toast.LENGTH_SHORT).show()
            binding.cardviewPreviewLocation.visibility = View.INVISIBLE
            return
        }

        // Use a coroutine tied to the fragment's lifecycle to handle the search
        // This is a safer alternative to GlobalScope.
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                // Ensure the Geocoder is properly initialized and handles API level differences
                val geocoder = Geocoder(requireContext(), Locale.getDefault())
                val addressList: List<Address>? =
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        // For API 33+, use the asynchronous geocode method
                        geocoder.getFromLocationName(locationName, 1)
                    } else {
                        // For older APIs, use the deprecated but synchronous method
                        geocoder.getFromLocationName(locationName, 1)
                    }

                // Switch back to the main thread to update the UI
                launch(Dispatchers.Main) {
                    if (!addressList.isNullOrEmpty()) {
                        val address = addressList[0]
                        val latLng = LatLng(address.latitude, address.longitude)
                        val addressLine = address.getAddressLine(0) // Get the full address line

                        binding.cardviewPreviewLocation.visibility = View.VISIBLE
                        // Use a safer way to get the address and handle null cases
                        binding.propertyTitle.text = locationName
                        binding.propertyAddress.text = addressLine

                        googleMap.clear()
                        googleMap.addMarker(
                            MarkerOptions()
                                .position(latLng)
                                .title(locationName)
                                .snippet(addressLine)
                        )
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))
//                        Toast.makeText(requireContext(), "Found: $addressLine", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(requireContext(), "Location not found", Toast.LENGTH_SHORT).show()
                        binding.cardviewPreviewLocation.visibility = View.INVISIBLE
                    }
                }
            } catch (e: IOException) {
                launch(Dispatchers.Main) {
                    Toast.makeText(requireContext(), "Error searching for location", Toast.LENGTH_SHORT).show()
                }
            } catch (e: IllegalArgumentException) {
                // Handle invalid location names
                launch(Dispatchers.Main) {
                    Toast.makeText(requireContext(), "Invalid location name provided", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onInfoWindowClick(marker: Marker) {
        Toast.makeText(
            requireContext(),
            "Info Window Clicked for: ${marker.title}",
            Toast.LENGTH_SHORT
        ).show()
    }
}