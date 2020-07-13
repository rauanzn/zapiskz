package com.example.domain.models


import com.google.gson.annotations.SerializedName

data class BeautyShopResponse(
    @SerializedName("data")
    var data: Data,
    @SerializedName("message")
    var message: String
)