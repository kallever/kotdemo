package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.myapplication.bean.Person
import com.example.myapplication.bean.Student
import com.example.myapplication.bean2.CellPhone
import com.example.myapplication.bean2.Singleton
import com.example.myapplication.bean2.Student2
import com.example.myapplication.listener.Study
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.test).setOnClickListener {
            student()
        }
    }

    fun student(){
//        val stu1 = Student()
//        val stu2 = Student("张三",18)
//        doStudy(stu2)
//        Log.d(TAG, stu2.toString())
//
//        val per = Person("张三",18)
//        per.eat()
//        val cellPhone =CellPhone("122121",111.0)
//        val cellPhone2 =CellPhone("122121",111.0)
//
//        Log.d(TAG, cellPhone.toString())
//        Log.d(TAG, "cellphone1 equals cellphone2 " + (cellPhone ==
//                cellPhone2))

//        val stu3 = Student("123456",2,"张三",18)

//        val stu4 = Student2()
//        val stu5 = Student2("张三",18)

//        Singleton.test()
        doStudy(null)
        Lambda()
    }

    private fun doStudy(study: Study?){
        study?.let {
            it.readBooks()
            it.doHomework()
        }

    }

    private fun Lambda(){
        val list = listOf("1","2","3")//不可变集合

        var list2 =mutableListOf("a","b","c")
        list2.add("aaa")
        for(i in list2){
//            Log.d(TAG,"i =$i")
        }


        val set = setOf("1","2","3","3")//不可变集合 不可重复

        var set2 = mutableSetOf("a","b","c")
        set2.add("aaa")
        for(i in set2){
//            Log.d(TAG,"i =$i")
        }

        val map = HashMap<String,Int>()
        map["a"] = 1
        map["b"] = 2
        map["c"] = 3
        map["d"] = 4
        map["e"] = 5


        val map2 = mapOf("a" to 1, "Banana" to 2, "Orange" to 3, "Pear" to
                4, "Grape" to 5)

        for ((str,i) in map2){
//            Log.d(TAG, "fruit is $str, number is $i")
        }
        val list3 = listOf("Apple", "Banana", "Orange", "Pear", "Grape",
            "Watermelon")

        val max = list3.maxBy { it.length }
        Log.d(TAG, "max $max")

//        val newList = list3.map { it.toUpperCase(Locale.ROOT) }
        val newList = list3.filter { it.length<=5 }.map { it.toUpperCase(Locale.ROOT) }
        for (fruit in newList){
            Log.d(TAG, "fruit is $fruit")
        }

        val anyresult = list3.any { it.length<5 } //是否存在5个字母以内的单词

        val allresult = list3.all { it.length<5 } //是否都是5个字母以内的单词
        Log.d(TAG, "anyResult is " + anyresult + ", allResult is " +
                allresult)

        main()
    }

    fun getTextLength(text:String?) = text?.length?:0

    var content: String? = "hello"
    fun main() {
        if (content != null) {
            printUpperCase()
        }
    }
    private fun printUpperCase() {
        val upperCase = content!!.toUpperCase()
        println(upperCase)
    }
}