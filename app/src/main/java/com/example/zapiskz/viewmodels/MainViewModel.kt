package com.example.zapiskz.viewmodels

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.annotation.CallSuper
import androidx.lifecycle.*
import com.example.data.repositories.BeautyShopRepository
import com.example.zapiskz.MyApplication
import com.example.zapiskz.state.Result
import javax.inject.Inject

abstract class MainViewModel(app: Application) : AndroidViewModel(app) {
    init {
        (app as MyApplication).appComponent?.doInjection(this)
    }
    @Inject
    lateinit var repository:BeautyShopRepository

    private val stateHolder = MutableLiveData(Unit)
    private var mIsAlive = false

    @SuppressLint("StaticFieldLeak")
    val context: Context = app.applicationContext

    val state = Transformations.switchMap(stateHolder){
        onCreateState()
    }

    abstract fun onCreateState(): LiveData<Result<Any>>

    @CallSuper
    open fun resetState() {
        stateHolder.postValue(Unit)
    }


    companion object {

        inline fun <reified M : MainViewModel> get(fragment: androidx.fragment.app.Fragment): M {
            return ViewModelProvider(fragment).get(M::class.java)
        }


    }
}