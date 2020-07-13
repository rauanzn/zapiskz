package com.example.domain.models


import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("id")
    var id: Int,
    @SerializedName("latitude")
    var latitude: Double,
    @SerializedName("longitude")
    var longitude: Double,
    @SerializedName("name")
    var name: String,
    @SerializedName("urlName")
    var urlName: String
)