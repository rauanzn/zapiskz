package com.example.zapiskz.usecases

import com.example.data.repositories.BeautyShopRepository
import com.example.domain.models.BeautyShopResponse
import kotlinx.coroutines.Deferred

class GetBeautyShopsUseCase (val repository: BeautyShopRepository){
    suspend fun getBeautyShops(): BeautyShopResponse =
        repository.getBeautyShops()
}