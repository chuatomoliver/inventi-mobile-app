package com.certicode.inventiapp

data class JobModel(
    val companyLogo: Int,
    val companyName: String,
    val jobTitle: String,
    val location: String,
    val jobTypes: List<String>
)