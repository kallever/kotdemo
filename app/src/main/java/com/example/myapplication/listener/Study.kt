package com.example.myapplication.listener

import android.util.Log

interface Study {
    fun readBooks()
    fun doHomework(){
        Log.d("study","do homework default implementation.")
    }
}