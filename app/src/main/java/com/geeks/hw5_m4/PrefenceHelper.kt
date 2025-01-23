package com.geeks.hw5_m4

import android.content.Context
import android.content.SharedPreferences

class PrefenceHelper {
    private lateinit var sharedPreferences: SharedPreferences
    fun unit(context: Context) {
        sharedPreferences = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
    }

    var text: String?
        get() = sharedPreferences.getString("text", "")
        set(value) = sharedPreferences.edit().putString("text", value).apply()
}