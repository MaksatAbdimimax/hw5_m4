package com.geeks.hw5_m4

import android.content.Context
import android.content.SharedPreferences

class PrefenceHelper {
    private lateinit var sharedPreferences: SharedPreferences
    fun unit(context: Context) {
        sharedPreferences = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
    }

    var board : Boolean
        get( )= sharedPreferences.getBoolean("board", false)
        set(value) = sharedPreferences.edit().putBoolean("board", value).apply()

    var text: String?
        get() = sharedPreferences.getString("text", "")
        set(value) = sharedPreferences.edit().putString("text", value).apply()
}