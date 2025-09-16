package com.certicode.inventiapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.certicode.inventiapp.R
import com.certicode.inventiapp.fragment.BookingListDetails
import com.certicode.inventiapp.models.ApartmentModel

class BookingListAdapter(
    private var bookingList: List<ApartmentModel>
):
    RecyclerView.Adapter<BookingListAdapter.BookingListViewHolder>(){

    fun updateList(newList: List<ApartmentModel>) {
        bookingList = newList
        notifyDataSetChanged()
    }

    class BookingListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        val imageHolder: ImageView = itemView.findViewById(R.id.imagePlaceHolder)
        val tagApartment: TextView = itemView.findViewById(R.id.tag_apartment)
        val rate: TextView = itemView.findViewById(R.id.rating_text)
        val title: TextView = itemView.findViewById(R.id.listing_title)
        val location: TextView = itemView.findViewById(R.id.location_text)
        val price: TextView = itemView.findViewById(R.id.price_text)
        val periodPrice: TextView = itemView.findViewById(R.id.price_period)

        val cancelBooking: Button = itemView.findViewById(R.id.cancelBooking)
        val viewDetails: Button = itemView.findViewById(R.id.viewDetails)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingListViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.booking_list_item, parent, false)
        return BookingListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookingListViewHolder, position: Int) {
        val bookingListProperty = bookingList[position]

        holder.imageHolder.setImageResource(bookingListProperty.imageResource)
        holder.rate.text = bookingListProperty.rating.toString()
        holder.title.text = bookingListProperty.title
        holder.location.text = bookingListProperty.location
        holder.price.text = "$${bookingListProperty.price}"

        holder.viewDetails.setOnClickListener {
            val fragment = BookingListDetails()
            val fragmentManager = (holder.itemView.context as AppCompatActivity).supportFragmentManager

            fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment) // fragment_container = FrameLayout in your activity
                .addToBackStack(null) // optional, allows back button to return
                .commit()

        }


    }

    override fun getItemCount() = bookingList.size
}