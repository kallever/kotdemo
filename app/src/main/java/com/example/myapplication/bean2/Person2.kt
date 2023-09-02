package com.example.myapplication.bean2

import android.util.Log

open class Person2(val name:String, val age:Int) {
    var TAG = "Person2"

    init {
        Log.d(TAG, "constructor name is $name age is $age")
    }
    fun eat(){
        Log.d(TAG,name + "is eating.He is "+age+" years old.")
    }
}