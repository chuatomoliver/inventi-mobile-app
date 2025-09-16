package com.certicode.inventiapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApartmentModel(
    val imageResource: Int,
    val title: String,
    val location: String,
    val rating: Double,
    val price: Int
) : Parcelable