package com.geeks.hw5_m4

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val sharedPreferences = PrefenceHelper()
        sharedPreferences.unit(this)
    }
}