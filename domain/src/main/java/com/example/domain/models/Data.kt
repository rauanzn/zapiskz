package com.example.domain.models


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("cities")
    var cities: List<City>,
    @SerializedName("isCategoriesHidden")
    var isCategoriesHidden: Boolean,
    @SerializedName("masters")
    var masters: List<Any>,
    @SerializedName("recentlyAddedFirms")
    var recentlyAddedFirms: List<Firm>,
    @SerializedName("recommendedFirms")
    var recommendedFirms: List<Firm>,
    @SerializedName("popularFirms")
    var popularFirms: List<Firm>,
    @SerializedName("updates")
    var updates: List<Any>
)