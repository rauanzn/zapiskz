package com.example.domain.models


import com.google.gson.annotations.SerializedName

data class Service(
    @SerializedName("categoryId")
    var categoryId: Int,
    @SerializedName("description")
    var description: String?,
    @SerializedName("duration")
    var duration: Int,
    @SerializedName("express")
    var express: Any?,
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("prepaymentAmount")
    var prepaymentAmount: Any?,
    @SerializedName("price")
    var price: Int,
    @SerializedName("priceMax")
    var priceMax: Int,
    @SerializedName("priceStr")
    var priceStr: String
)