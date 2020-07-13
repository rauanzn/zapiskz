package com.example.zapiskz

import android.app.Application
import android.content.Context
import com.example.zapiskz.components.AppComponent
import com.example.zapiskz.components.DaggerAppComponent
import com.example.zapiskz.modules.NetworkModule

@Suppress("DEPRECATION")
class MyApplication : Application() {
    var appComponent: AppComponent? = null
    var context: Context? = null
    val networkModule = NetworkModule()
    override fun onCreate() {
        super.onCreate()
        context = this
        appComponent = DaggerAppComponent.builder().networkModule(networkModule).build()
    }
}
