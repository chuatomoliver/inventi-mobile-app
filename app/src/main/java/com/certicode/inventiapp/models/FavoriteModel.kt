package com.certicode.inventiapp.models

data class FavoriteModel(
    val imagePlaceHolder: Int,
    val tagApartment: String,
    val rating: Double,
    val title: String,
    val location: String,
    val price: Int,
    val pricePeriod: String,

    val type: String,
)