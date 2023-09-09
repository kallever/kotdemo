package com.example.myapplication.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.myapplication.R

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
    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView")
        val view = inflater.inflate(R.layout.fragment_two, container,
            false)
        view.findViewById<Button>(R.id.button).setOnClickListener {
           text()

        }
        return view
    }


    //高阶函数
    fun example(func:(String,Int) ->Unit){
        func("hello",123)
    }

    fun text2(){
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

    fun java.lang.StringBuilder.build(block:java.lang.StringBuilder.() -> Unit):java.lang.StringBuilder{
        block
        return this
    }

    //使⽤了传⼊的函数类型参数来决定具体的运算逻辑
    fun text(){
        val num1 = 100
        val num2 = 30
        Log.d(TAG,"plus "+num1Andnum2(num1,num2,::plus))
        Log.d(TAG,"minus "+num1Andnum2(num1,num2,::minus))

        Log.d(TAG,"plus2 "+num1Andnum2(num1,num2) { n1, n2 -> n1 + n2 })
        Log.d(TAG,"minus2 "+num1Andnum2(num1,num2) { n1, n2 -> n1 - n2 })

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


    //是在匿名类中调⽤了传⼊的函数类型参数。
    //因为内联函数的Lambda表达式中允许使
    //⽤return关键字，和⾼阶函数的匿名类实现中不允许使⽤return关键字
    //之间造成了冲突。⽽crossinline关键字就像⼀个契约，它⽤于保证在内
    //联函数的Lambda表达式中⼀定不会使⽤return关键字，这样冲突就不存
    //在了，问题也就巧妙地解决了。
    inline fun runRunnable(crossinline block:()->Unit){
        val runnable = Runnable {
            block()
        }
    }

    //内联函数所引
    //⽤的Lambda表达式中是可以使⽤return关键字来进⾏函数返回的(相当于函数被return)，⽽⾮内联函数只能进⾏局部返回return@printString(相当于方法被return)
    inline fun printString(string: String,block: (String) -> Unit){
        println("printString begin")
        block(string)
        println("printString end")
    }
    //inline 是Kotlin编译器会
    //将内联函数中的代码在编译的时候⾃动替换到调⽤它的地⽅，这样也就不
    //存在运⾏时的开销了。
    //内联的函数类型参数只允许传递给另外⼀个内联函数，这也是它最⼤的局
    //限性。
    inline fun num1Andnum2(num1:Int,num2:Int,operation:(Int,Int)->Int):Int{
        return operation(num1,num2)
    }

    fun plus(num1: Int,num2: Int):Int{
        return num1+num2
    }

    fun minus(num1: Int,num2: Int):Int{
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

