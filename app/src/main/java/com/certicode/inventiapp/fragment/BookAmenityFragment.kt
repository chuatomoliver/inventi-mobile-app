package com.certicode.inventiapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.certicode.inventiapp.R
import com.certicode.inventiapp.models.AmenitiesModel


class BookAmenityFragment : Fragment() {

    private var amenity: AmenitiesModel? = null
    private lateinit var imagePlaceHolder: ImageView
    private lateinit var amenitiesTitle: TextView
    private lateinit var locationText: TextView
    private lateinit var ratingText: TextView
    private lateinit var reviewsText: TextView
    private lateinit var tagText: TextView

    private lateinit var description: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_book_amenity, container, false)
        amenity = arguments?.getParcelable(ARG_AMENITY)
        imagePlaceHolder = view.findViewById(R.id.imagePlaceHolder)
        amenitiesTitle = view.findViewById(R.id.amenitiesTitle)
        locationText = view.findViewById(R.id.location_text)
        ratingText = view.findViewById(R.id.rating_text)
        reviewsText = view.findViewById(R.id.amenityReviews)
        tagText = view.findViewById(R.id.tag_apartment)
        description = view.findViewById(R.id.description)

        uiSetup()
        return view
    }


    private fun uiSetup(){

        amenity?.let{ a ->
            imagePlaceHolder.setImageResource(a.imagePlaceHolder)
            amenitiesTitle.text = a.amenitiesTitle
            locationText.text = a.location
            ratingText.text = a.rating.toString()
            reviewsText.text = "(${a.reviews} reviews)"
            tagText.text = a.tagAmenity
            description.text = a.description
        }
    }
    companion object {
        private const val ARG_AMENITY = "amenity"

        fun newInstance(amenity: AmenitiesModel): BookAmenityFragment{
            val fragment = BookAmenityFragment()
            val bundle = Bundle().apply {
                putParcelable(ARG_AMENITY, amenity)
            }
            fragment.arguments = bundle
            return fragment
        }
    }


    override fun onResume() {
        super.onResume()
        // Hide when this fragment is visible
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.GONE
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE
    }


}