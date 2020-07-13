package com.example.zapiskz.usecases

import com.example.data.repositories.BeautyShopRepository
import com.example.domain.models.BeautyShopDetailResponse

class GetBeautyShopDetailUseCase(val repository: BeautyShopRepository) {
    suspend fun getDetail(id:Int) :BeautyShopDetailResponse = repository.getBeautyShopDetail(id)
}