package com.example.zapiskz.viewmodels

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.zapiskz.state.Result
import androidx.lifecycle.*
import com.example.domain.models.BeautyShopDetailResponse
import com.example.zapiskz.usecases.GetBeautyShopDetailUseCase
import com.example.zapiskz.viewmodels.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShopDetailViewModel(app:Application) : MainViewModel(app) {
    private val detailId = MutableLiveData<Int>()
    init {
        loadBeautyShops()
    }
    private val result = MutableLiveData<Result<Any>>(Result.BeautyShopResponse.Loading)
    override fun onCreateState(): LiveData<Result<Any>> = result
    private val _shopDetail = MutableLiveData<BeautyShopDetailResponse>()
    fun loadBeautyShops(){
        detailId.observeForever {
            viewModelScope.launch(Dispatchers.IO) {
                val data = GetBeautyShopDetailUseCase(
                    repository
                ).getDetail(it)
                result.postValue(Result.BeautyShopDetailResponse.Success(data))
                _shopDetail.postValue(data)
            }
        }
    }
    fun getShopDetail():LiveData<BeautyShopDetailResponse> = _shopDetail
    fun setDetailId(id:Int) {
        if (id != -1 && detailId.value != id) detailId.value = id

    }
}