package com.example.zapiskz.frameworks

import com.example.data.repositories.BeautyShopRepository
import com.example.domain.models.BeautyShopDetailResponse
import com.example.domain.models.BeautyShopResponse
import com.example.zapiskz.api.BeautyShopApi
import kotlinx.coroutines.Deferred

class BeautyShopRepositoryImpl(val beautiShopApi:BeautyShopApi) :BeautyShopRepository{
    override suspend fun getBeautyShops(): BeautyShopResponse {
        return beautiShopApi.getAllShops()
    }

    override suspend fun getBeautyShopDetail(id: Int): BeautyShopDetailResponse =
        beautiShopApi.getSalonDetail(id)

}