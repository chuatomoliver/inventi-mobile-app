package com.certicode.inventiapp.models

data class ApartmentModel(
    val imageResource: Int,
    val title: String,
    val location: String,
    val rating: Double,
    val price: Int
)