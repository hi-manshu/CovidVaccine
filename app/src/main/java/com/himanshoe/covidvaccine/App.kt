package com.himanshoe.covidvaccine

import android.app.Application
import com.himanshoe.core.storage.StoreInitializer
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    
    override fun onCreate() {
        super.onCreate()
        StoreInitializer.init(this)
    }
}