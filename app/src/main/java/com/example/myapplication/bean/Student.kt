package com.example.myapplication.bean

import android.util.Log
import com.example.myapplication.listener.Study

class Student (sno:String, grade:Int, name: String, age:Int):Person(name,age),Study{
    //次构造函数必须调用主构造函数 所以执行顺序是 1 2 3
    init {
        TAG ="Student"
        Log.d(TAG, "constructor3 name is $name age is $age sno is $sno grade is $grade")
    }

    constructor(name: String,age: Int):this("123",2,name,age){
        Log.d(TAG, "constructor2 name is $name age is $age")
    }
    constructor():this("111", 1){
        Log.d(TAG, "constructor1 name is $name age is $age")
    }

    override fun readBooks() {
        Log.d(TAG,"$name is reading")
    }

//    override fun doHomework() {
//        Log.d(TAG,"$name is doHomework")
//    }
}