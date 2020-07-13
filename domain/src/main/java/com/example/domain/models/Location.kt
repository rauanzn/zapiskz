package com.example.domain.models


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("centerX")
    var centerX: Double,
    @SerializedName("centerY")
    var centerY: Double,
    @SerializedName("markerX")
    var markerX: Double,
    @SerializedName("markerY")
    var markerY: Double,
    @SerializedName("type")
    var type: String,
    @SerializedName("zoom")
    var zoom: Int
)