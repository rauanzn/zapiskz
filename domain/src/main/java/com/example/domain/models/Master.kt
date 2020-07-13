package com.example.domain.models


import com.google.gson.annotations.SerializedName

data class Master(
    @SerializedName("avatarUrl")
    var avatarUrl: String,
    @SerializedName("capacity")
    var capacity: Any?,
    @SerializedName("experience")
    var experience: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("profession")
    var profession: String,
    @SerializedName("rating")
    var rating: Float,
    @SerializedName("serviceIds")
    var serviceIds: List<Int>,
    @SerializedName("surname")
    var surname: String
)