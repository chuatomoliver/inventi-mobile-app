package com.certicode.inventiapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AmenitiesModel (
    val imagePlaceHolder: Int,
    val reviews: Int,
    val amenityFee: Double,
    val rating: Double,
    val location: String,
    val tagAmenity: String,
    val amenitiesTitle: String,
    val description: String,
) : Parcelable
