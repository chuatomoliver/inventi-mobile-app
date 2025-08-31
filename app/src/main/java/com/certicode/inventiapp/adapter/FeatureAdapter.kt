package com.certicode.inventiapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.certicode.inventiapp.R
import com.certicode.inventiapp.models.FeatureModel


class FeatureAdapter(private val features: List<FeatureModel>) : RecyclerView.Adapter<FeatureAdapter.FeatureViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeatureViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.feature_item,
        parent, false)
        return FeatureViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeatureViewHolder, position: Int) {
        val feature = features[position]
        holder.bind(feature)
    }

    override fun getItemCount(): Int = features.size

    class FeatureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Bind views here
        private val featureImage: ImageView = itemView.findViewById(R.id.feature_image)
        private val featureTitle: TextView = itemView.findViewById(R.id.tvTitle)


        fun bind(feature: FeatureModel) {
            // Set data to views
            featureImage.setImageResource(feature.featureLogo)
            featureTitle.text = feature.featureName
        }
    }
}