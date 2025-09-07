package com.certicode.inventiapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.certicode.inventiapp.R
import com.certicode.inventiapp.models.AmenitiesModel

class AmenityAdapter(
    private val amenitiesList: List<AmenitiesModel>
) : RecyclerView.Adapter<AmenityAdapter.AmenityViewHolder>() {

    // ViewHolder class
    class AmenityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagePlaceHolder: ImageView = itemView.findViewById(R.id.imagePlaceHolder)
        val amenitiesTitle: TextView = itemView.findViewById(R.id.amenitiesTitle)
        val locationText: TextView = itemView.findViewById(R.id.location_text)
        val amenityFee: TextView = itemView.findViewById(R.id.amenityFee)
        val pricePeriod: TextView = itemView.findViewById(R.id.price_period)
        val ratingText: TextView = itemView.findViewById(R.id.rating_text)
        val reviewsText: TextView = itemView.findViewById(R.id.amenityReviews)
        val tagAmenity: TextView = itemView.findViewById(R.id.tag_Amenity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmenityViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.ammenities_item, parent, false)
        return AmenityViewHolder(view)
    }

    override fun onBindViewHolder(holder: AmenityViewHolder, position: Int) {
        val item = amenitiesList[position]

        holder.imagePlaceHolder.setImageResource(item.imagePlaceHolder)
        holder.amenitiesTitle.text = item.amenitiesTitle
        holder.locationText.text = item.location
        holder.amenityFee.text = "$${item.amenityFee}" // Peso sign, change if needed
        holder.pricePeriod.text = "/month" // static for now
        holder.ratingText.text = item.rating.toString()
        holder.reviewsText.text = "(${item.reviews} reviews)"
        holder.tagAmenity.text = item.tagAmenity
    }

    override fun getItemCount(): Int = amenitiesList.size
}
