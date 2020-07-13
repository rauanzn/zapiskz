package com.example.zapiskz.components

import com.example.zapiskz.viewmodels.MainViewModel
import com.example.zapiskz.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface AppComponent {
    fun doInjection(mainViewModel: MainViewModel)
}