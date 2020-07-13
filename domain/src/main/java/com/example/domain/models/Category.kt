package com.example.domain.models


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String
)