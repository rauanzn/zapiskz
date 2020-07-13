package com.example.domain.models


import com.google.gson.annotations.SerializedName

data class FirmX(
    @SerializedName("address")
    var address: String,
    @SerializedName("avatarUrl")
    var avatarUrl: String,
    @SerializedName("category")
    var category: String,
    @SerializedName("checkRating")
    var checkRating: Float,
    @SerializedName("cityName")
    var cityName: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("instagramProfile")
    var instagramProfile: String?,
    @SerializedName("isClientSurnameRequired")
    var isClientSurnameRequired: Boolean?,
    @SerializedName("isExpress")
    var isExpress: Boolean?,
    @SerializedName("isMastersHidden")
    var isMastersHidden: Boolean?,
    @SerializedName("isPromoted")
    var isPromoted: Boolean?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("phoneNumbers")
    var phoneNumbers: List<String>?,
    @SerializedName("pictures")
    var pictures: List<String>?,
    @SerializedName("todayReservationsCount")
    var todayReservationsCount: Any?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("urlKey")
    var urlKey: String?,
    @SerializedName("workEndTime")
    var workEndTime: String?,
    @SerializedName("workStartTime")
    var workStartTime: String?,
    @SerializedName("averageRating")
    var averageRating: Float?
)