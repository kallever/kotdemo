package util

import android.util.Log

/**顶层方法 一定是静态方法 所有的顶层⽅法都可以在
*任何位置被直接调⽤，不⽤管包名路径，也不⽤创建实例
 *
 * */
private const val TAG ="String"


//统计某个字符串中的字⺟数量时
fun String.lettersCount():Int{
    Log.d(TAG,"doSomething")
    var count =0
    for(char in this){
        if(char.isLetter()){
            count++
        }
    }
    return count
}

operator fun String.times(n:Int):String{
    val builder=java.lang.StringBuilder()
    repeat(n){
        builder.append(this)
    }
    return builder.toString()
}