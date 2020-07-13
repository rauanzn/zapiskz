package com.example.zapiskz.api

import com.example.domain.models.BeautyShopDetailResponse
import com.example.domain.models.BeautyShopResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface BeautyShopApi{

    @GET("v1/screen/home")
    suspend fun getAllShops():BeautyShopResponse

    @GET("v1/firms/{firmId}")
    suspend fun getSalonDetail(@Path("firmId") id: Int): BeautyShopDetailResponse
}