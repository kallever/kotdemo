package com.example.myapplication.bean

import android.util.Log

open class Person(val name:String,val age:Int) {
    var TAG = "Person"


    fun eat(){
        Log.d(TAG,name + "is eating.He is "+age+" years old.")
    }
}