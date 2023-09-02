package com.example.myapplication.bean2

import android.util.Log

class Student2 :Person2{
    //既然没有主构造函数，继承Person类的时候也就不需要再加上括号了
    init {
        TAG ="Student2"
        Log.d(TAG, "constructor3 name is $name age is $age")
    }

    //次构造函数只能直接调⽤⽗类的构造函数
    constructor(name: String,age: Int):super(name,age){
        Log.d(TAG, "constructor2 name is $name age is $age")
    }
    constructor():this("111", 1){
        Log.d(TAG, "constructor1 name is $name age is $age")
    }
}