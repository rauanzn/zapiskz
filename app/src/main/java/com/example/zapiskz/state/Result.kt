package com.example.zapiskz.state

import com.example.domain.models.BeautyShopDetailResponse
import com.example.domain.models.BeautyShopResponse

sealed class Result<out T>{
    sealed class BeautyShopResponse {
        object Loading : Result<Unit>()
        data class Success(val shops: com.example.domain.models.BeautyShopResponse?) : Result<com.example.domain.models.BeautyShopResponse>()
        data class Failure(val throwable: Throwable?) : Result<Throwable>()
    }
    sealed class BeautyShopDetailResponse{
        object Loading : Result<Unit>()
        data class Success(val shop: com.example.domain.models.BeautyShopDetailResponse?) : Result<com.example.domain.models.BeautyShopDetailResponse>()
        data class Failure(val throwable: Throwable?) : Result<Throwable>()
    }
}
