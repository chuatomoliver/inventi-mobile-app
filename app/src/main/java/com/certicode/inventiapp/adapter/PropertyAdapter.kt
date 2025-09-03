package com.certicode.inventiapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.certicode.inventiapp.R
import com.certicode.inventiapp.adapter.FavoriteAdapter.FavoriteViewHolder
import com.certicode.inventiapp.models.PropertyModel

class PropertyAdapter (
    private var imagePropertyList: List<PropertyModel>
) : RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder>(){

    class PropertyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        val imageHolder: ImageView = itemView.findViewById(R.id.imagePlaceHolder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.property_img_item, parent, false)

        return PropertyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PropertyViewHolder, position: Int) {
        val propertyList = imagePropertyList[position]
        holder.imageHolder.setImageResource(propertyList.imagePlaceHolder)
    }


    override fun getItemCount() = imagePropertyList.size
}

