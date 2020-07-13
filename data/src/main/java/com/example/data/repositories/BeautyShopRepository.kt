package com.example.data.repositories

import com.example.domain.models.BeautyShopDetailResponse
import com.example.domain.models.BeautyShopResponse
import kotlinx.coroutines.Deferred

interface BeautyShopRepository{
    suspend fun getBeautyShops(): BeautyShopResponse
    suspend fun getBeautyShopDetail(id:Int):BeautyShopDetailResponse
}