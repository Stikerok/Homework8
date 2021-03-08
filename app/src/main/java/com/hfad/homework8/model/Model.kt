package com.hfad.homework8.model

import android.content.Context


const val PIN = "1245"
class Model (context: Context) {
    private val sp = context.getSharedPreferences("App", Context.MODE_PRIVATE)
    fun saveTime(mill : Long) {
        sp.edit().putLong("time",mill).apply()
    }
    fun getTime() : Long {
        return sp.getLong("time",10000)
    }
    fun pinIsTrue(pin : String) : Boolean {
        return PIN == pin
    }

}