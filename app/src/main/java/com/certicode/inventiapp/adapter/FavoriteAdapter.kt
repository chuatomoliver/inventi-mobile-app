package com.certicode.inventiapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.certicode.inventiapp.R
import com.certicode.inventiapp.models.FavoriteModel

class FavoriteAdapter(private var favoriteList: List<FavoriteModel>):
RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>(){

    fun updateList(newList: List<FavoriteModel>) {
        favoriteList = newList
        notifyDataSetChanged()
    }

    class FavoriteViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        val imageHolder: ImageView = itemView.findViewById(R.id.imagePlaceHolder)
        val tagApartment: TextView = itemView.findViewById(R.id.tag_apartment)
        val rate: TextView = itemView.findViewById(R.id.rating_text)
        val title: TextView = itemView.findViewById(R.id.listing_title)
        val location: TextView = itemView.findViewById(R.id.location_text)
        val price: TextView = itemView.findViewById(R.id.price_text)
        val periodPrice: TextView = itemView.findViewById(R.id.price_period)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.favorite_apartment_item, parent, false)
        return FavoriteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val favoriteApartment = favoriteList[position]

        holder.imageHolder.setImageResource(favoriteApartment.imagePlaceHolder)
        holder.tagApartment.text = favoriteApartment.tagApartment
        holder.rate.text = favoriteApartment.rating.toString()
        holder.title.text = favoriteApartment.title
        holder.location.text = favoriteApartment.location
        holder.price.text = "$${favoriteApartment.price}"
        holder.periodPrice.text = " /${favoriteApartment.pricePeriod}"


    }

    override fun getItemCount() = favoriteList.size
}