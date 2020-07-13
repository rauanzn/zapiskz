package com.example.domain.models


import com.google.gson.annotations.SerializedName

data class BeautyShopDetailResponse(
    @SerializedName("data")
    var data: DataX,
    @SerializedName("message")
    var message: String
)