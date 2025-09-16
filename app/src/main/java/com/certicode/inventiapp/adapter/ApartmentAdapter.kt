package com.certicode.inventiapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.certicode.inventiapp.R
import com.certicode.inventiapp.databinding.FavoriteApartmentItemBinding
import com.certicode.inventiapp.fragment.FavoriteApartmentFragment
import com.certicode.inventiapp.models.ApartmentModel

class ApartmentAdapter(
    private val apartmentList: List<ApartmentModel>,
    private val fragmentManager: FragmentManager
) :
    RecyclerView.Adapter<ApartmentAdapter.ApartmentViewHolder>() {

    /**
     * ViewHolder for the apartment list item.
     * This class holds references to the views in our XML layout.
     *
     * @param itemView The root view of the list item layout (the CardView in our case).
     */

    class ApartmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val apartmentImage: ImageView = itemView.findViewById(R.id.apartment_image)
        val favIcon: ImageView = itemView.findViewById(R.id.favorite_icon)
        val listingTitle: TextView = itemView.findViewById(R.id.listing_title)
        val locationText: TextView = itemView.findViewById(R.id.location_text)
        val ratingText: TextView = itemView.findViewById(R.id.rating_text)
        val priceText: TextView = itemView.findViewById(R.id.price_text)
    }

    /**
     * Called when RecyclerView needs a new ViewHolder.
     * It inflates the XML layout and returns a new ViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApartmentViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_item_recommendations, parent, false)
        return ApartmentViewHolder(itemView)
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     * This is where you bind the data from your model to the views in the ViewHolder.
     */
    override fun onBindViewHolder(holder: ApartmentViewHolder, position: Int) {
        val currentApartment = apartmentList[position]

        // Set the image from the resource ID in the data model
        holder.apartmentImage.setImageResource(currentApartment.imageResource)

        // Set the text for the title, location, rating, and price
        holder.listingTitle.text = currentApartment.title
        holder.locationText.text = currentApartment.location
        holder.ratingText.text = currentApartment.rating.toString()
        holder.priceText.text = currentApartment.price.toString()


        holder.favIcon.setOnClickListener({

            val fragment = FavoriteApartmentFragment()
            fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()

        })
    }

    /**
     * Returns the total number of items in the list.
     */
    override fun getItemCount() = apartmentList.size
}
