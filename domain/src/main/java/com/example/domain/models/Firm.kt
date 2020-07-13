package com.example.domain.models


import com.google.gson.annotations.SerializedName

data class Firm(
    @SerializedName("address")
    var address: String,
    @SerializedName("avatarUrl")
    var avatarUrl: String,
    @SerializedName("averageRating")
    var averageRating: Float,
    @SerializedName("checkRating")
    var checkRating: Int,
    @SerializedName("id")
    var id: Int,
    @SerializedName("isFavorite")
    var isFavorite: Boolean,
    @SerializedName("isIndividualMaster")
    var isIndividualMaster: Boolean,
    @SerializedName("isPromoted")
    var isPromoted: Boolean,
    @SerializedName("name")
    var name: String,
    @SerializedName("pictureUrl")
    var pictureUrl: String,
    @SerializedName("prepaymentCashbackAmount")
    var prepaymentCashbackAmount: String,
    @SerializedName("todayReservationsCount")
    var todayReservationsCount: Any?,
    @SerializedName("type")
    var type: String,
    @SerializedName("urlKey")
    var urlKey: String,
    @SerializedName("workSchedule")
    var workSchedule: String
)