package com.example.zapiskz.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.example.domain.models.Firm
import com.example.zapiskz.state.Result
import com.example.zapiskz.usecases.GetBeautyShopsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BeautyShopsViewModel(app:Application) : MainViewModel(app) {
    init {
        loadBeautyShops()
    }
    private val result = MutableLiveData<Result<Any>>(Result.BeautyShopResponse.Loading)
    override fun onCreateState(): LiveData<Result<Any>> = result
    private val _shopsRec = MutableLiveData<List<Firm>>()
    private val _shopsPop = MutableLiveData<List<Firm>>()
    private val _shopsRecentlyAdded = MutableLiveData<List<Firm>>()

    fun loadBeautyShops(){
        viewModelScope.launch(Dispatchers.IO) {
            val data = GetBeautyShopsUseCase(
                repository
            ).getBeautyShops()
            result.postValue(Result.BeautyShopResponse.Success(data))
            _shopsPop.postValue(data.data.popularFirms)
            _shopsRec.postValue(data.data.recommendedFirms)
            _shopsRecentlyAdded.postValue(data.data.recentlyAddedFirms)
        }
    }
    fun getShopsRec():LiveData<List<Firm>> = _shopsRec
    fun getShopsPop():LiveData<List<Firm>> = _shopsPop
    fun getShopsRecentlyAdded(): LiveData<List<Firm>> = _shopsRecentlyAdded
}