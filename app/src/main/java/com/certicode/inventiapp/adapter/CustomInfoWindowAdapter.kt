package com.certicode.inventiapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.certicode.inventiapp.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

class CustomInfoWindowAdapter(private val context: Context) : GoogleMap.InfoWindowAdapter {

    private val window: View = LayoutInflater.from(context).inflate(R.layout.menu_item_pin_cardview, null)

    private fun renderWindowText(marker: Marker, view: View) {
        val titleTextView: TextView = view.findViewById(R.id.property_title)
        val snippetTextView: TextView = view.findViewById(R.id.property_address)

        // Set the title and snippet from the marker to your custom views
        val title = marker.title
        if (title != null) {
            titleTextView.text = title
        } else {
            titleTextView.text = ""
        }

        val snippet = marker.snippet
        if (snippet != null) {
            snippetTextView.text = snippet
        } else {
            snippetTextView.text = ""
        }
    }

    override fun getInfoWindow(marker: Marker): View {
        renderWindowText(marker, window)
        return window
    }

    override fun getInfoContents(marker: Marker): View? {
        return null // Returning null will trigger getInfoWindow
    }
}