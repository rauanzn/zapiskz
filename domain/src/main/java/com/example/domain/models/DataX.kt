package com.example.domain.models


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("categories")
    var categories: List<Category>,
    @SerializedName("firm")
    var firm: FirmX,
    @SerializedName("instagram")
    var instagram: String?,
    @SerializedName("isOnline")
    var isOnline: Boolean,
    @SerializedName("location")
    var location: Location,
    @SerializedName("masters")
    var masters: List<Master>,
    @SerializedName("services")
    var services: List<Service>
)