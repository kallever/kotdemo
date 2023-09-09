package com.example.myapplication.fragment

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.sql.MyDataHelper
import util.cvof
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * A simple [Fragment] subclass.
 * Use the [TwoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TwoFragment : Fragment() {
    companion object {
        const val TAG = "TwoFragment"
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }
    var sql: MyDataHelper? = null

    override fun onCreateView(
        inflater: LayoutInflater, container:
        ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")
        val view = inflater.inflate(
            R.layout.fragment_two, container,
            false
        )
        view.findViewById<Button>(R.id.button).setOnClickListener {
//           text()
//            save("testtest")
//            Log.d(TAG,"text :"+read())
            sql()
        }
        sql = context?.let { MyDataHelper(it,"book.db",5) }!!

        view.findViewById<Button>(R.id.updateSQL).setOnClickListener {
//           text()
//            save("testtest")
//            Log.d(TAG,"text :"+read())
            shiwu()
        }

        view.findViewById<Button>(R.id.deleteSQL).setOnClickListener {
//           text()
//            save("testtest")
//            Log.d(TAG,"text :"+read())
            sqlDelete()
        }

        view.findViewById<Button>(R.id.querySQL).setOnClickListener {
            sqlqurey()
        }
        return view
    }

    fun testSp(){
        context?.getSharedPreferences("data",Context.MODE_PRIVATE)?.open {
            putString("name", "Tom")
            putInt("age", 28)
            putBoolean("married", false)
        }
    }

    fun SharedPreferences.open(block:  SharedPreferences.Editor.() -> Unit){
        val editor = edit()
        editor.block()
        editor.apply()
    }

    fun shiwu(){
        val db = sql?.writableDatabase
        db?.beginTransaction()
        try {
            db?.delete("Book",null,null)
//            if(true){
//                throw java.lang.NullPointerException()
//            }
//            val values = ContentValues().apply {
//                put("id",3)
//                put("name", "Game of Thrones")
//                put("author", "George Martin")
//                put("pages", 720)
//                put("price", 20.85)
//            }
            val values = cvof("name" to "Game of Thrones", "author" to "George Martin",
                "pages" to 720, "price" to 20.85)
            db?.insert("Book",null,values)
            db?.setTransactionSuccessful()
        }catch (e:java.lang.Exception){
            e.printStackTrace()
        }finally {
            db?.endTransaction()
        }
    }
    @SuppressLint("Range")
    fun sqlqurey(){
        val db =sql?.writableDatabase
        val cursor = db?.query("Book", null, null, null, null, null,
            null)
        if(cursor?.moveToFirst() == true){
            do{
                val id = cursor.getInt(cursor.getColumnIndex("id"))

                val name = cursor.getString(cursor.getColumnIndex("name"))
                val author =
                    cursor.getString(cursor.getColumnIndex("author"))
                val pages =
                    cursor.getInt(cursor.getColumnIndex("pages"))
                val price =
                    cursor.getDouble(cursor.getColumnIndex("price"))
                Log.d(TAG, "book id is $id")
                Log.d(TAG, "book name is $name")
                Log.d(TAG, "book author is $author")
                Log.d(TAG, "book pages is $pages")
                Log.d(TAG, "book price is $price")

            }while (cursor.moveToNext())
        }
        cursor?.close()
    }
    fun sqlUpdate(){
        val db =sql?.writableDatabase
        val values1 = ContentValues()
        values1.put("price",10.99)
        db?.update("Book",values1,"name = ?",arrayOf("The Da Vinci Code"))
    }


    fun sqlDelete(){
        val db = sql?.writableDatabase
        db?.delete("Book", "pages > ?", arrayOf("500"))
    }
    fun sql(){
        val db =sql?.writableDatabase
        val values1 = ContentValues().apply{
            put("id",1)
            put("name", "The Da Vinci Code")
            put("author", "Dan Brown")
            put("pages", 454)
            put("price", 16.96)
        }
        db?.insert("Book",null,values1)

        val values2 = ContentValues().apply {
            // 开始组装第⼆条数据
            put("id",2)
            put("name", "The Lost Symbol")
            put("author", "Dan Brown")
            put("pages", 510)
            put("price", 19.95)
        }
        db?.insert("Book", null, values2) // 插⼊第⼆条数据
    }



    //高阶函数
    fun example(func: (String, Int) -> Unit) {
        func("hello", 123)
    }

    fun text2() {
        val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
//        val result = StringBuilder().apply {
//            append("Start eating fruits.\n")
//            for (fruit in list) {
//                append(fruit).append("\n")
//            }
//            append("Ate all fruits.")
//        }
//        println(result.toString())

        val result = StringBuilder().build {
            append("Start eating fruits.\n")
            for (fruit in list) {
                append(fruit).append("\n")
            }
            append("Ate all fruits.")
        }
        println(result.toString())
    }

    fun java.lang.StringBuilder.build(block: java.lang.StringBuilder.() -> Unit): java.lang.StringBuilder {
        block
        return this
    }

    //使⽤了传⼊的函数类型参数来决定具体的运算逻辑
    fun text() {
        val num1 = 100
        val num2 = 30
        Log.d(TAG, "plus " + num1Andnum2(num1, num2, ::plus))
        Log.d(TAG, "minus " + num1Andnum2(num1, num2, ::minus))

        Log.d(TAG, "plus2 " + num1Andnum2(num1, num2) { n1, n2 -> n1 + n2 })
        Log.d(TAG, "minus2 " + num1Andnum2(num1, num2) { n1, n2 -> n1 - n2 })

        println("main start")
        val str = ""
        printString(str) { s ->
            println("lambda start")
            if (s.isEmpty()) return
            println(s)
            println("lambda end")
        }
        println("main end")
    }


    fun read():String{
        val content = StringBuilder()
        try {
            val input = this.context?.openFileInput("data.txt")
            val read = BufferedReader(InputStreamReader(input))
            //use函数，这是Kotlin提供的⼀个内置扩展函数。
            //它会保证在Lambda表达式中的代码全部执⾏完之后⾃动将外层的流关 闭
            read.use {
                it.forEachLine { it ->
                    content.append(it)
                }
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()

        }
        return content.toString()
    }

    fun save(input: String) {
        try {
            val output = this.context?.openFileOutput("data.txt", Context.MODE_PRIVATE)
            val write = BufferedWriter(OutputStreamWriter(output))
            //use函数，这是Kotlin提供的⼀个内置扩展函数。
            //它会保证在Lambda表达式中的代码全部执⾏完之后⾃动将外层的流关 闭
            write.use {
                it.write(input)
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()

        }
    }

    //是在匿名类中调⽤了传⼊的函数类型参数。
    //因为内联函数的Lambda表达式中允许使
    //⽤return关键字，和⾼阶函数的匿名类实现中不允许使⽤return关键字
    //之间造成了冲突。⽽crossinline关键字就像⼀个契约，它⽤于保证在内
    //联函数的Lambda表达式中⼀定不会使⽤return关键字，这样冲突就不存
    //在了，问题也就巧妙地解决了。
    inline fun runRunnable(crossinline block: () -> Unit) {
        val runnable = Runnable {
            block()
        }
    }

    //内联函数所引
    //⽤的Lambda表达式中是可以使⽤return关键字来进⾏函数返回的(相当于函数被return)，⽽⾮内联函数只能进⾏局部返回return@printString(相当于方法被return)
    inline fun printString(string: String, block: (String) -> Unit) {
        println("printString begin")
        block(string)
        println("printString end")
    }

    //inline 是Kotlin编译器会
    //将内联函数中的代码在编译的时候⾃动替换到调⽤它的地⽅，这样也就不
    //存在运⾏时的开销了。
    //内联的函数类型参数只允许传递给另外⼀个内联函数，这也是它最⼤的局
    //限性。
    inline fun num1Andnum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
        return operation(num1, num2)
    }

    fun plus(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    fun minus(num1: Int, num2: Int): Int {
        return num1 - num2
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach")
    }
}

