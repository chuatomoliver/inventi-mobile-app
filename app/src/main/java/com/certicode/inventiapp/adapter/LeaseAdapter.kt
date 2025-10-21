package com.certicode.inventiapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.certicode.inventiapp.R
import com.certicode.inventiapp.models.LeaseItem


class LeaseAdapter(
    private val leaseList: List<LeaseItem>
) : RecyclerView.Adapter<LeaseAdapter.LeaseViewHolder>() {

    inner class LeaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val description: TextView = itemView.findViewById(R.id.description)
        val imagePlaceHolder: ImageView = itemView.findViewById(R.id.imagePlaceHolder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.lease_item, parent, false) // Change to your file name
        return LeaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: LeaseViewHolder, position: Int) {
        val item = leaseList[position]
        holder.title.text = item.title
        holder.description.text = item.description
        holder.imagePlaceHolder.setImageResource(item.imageResId)
    }

    override fun getItemCount(): Int = leaseList.size
}
