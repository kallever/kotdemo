package util

import android.util.Log

/**顶层方法 一定是静态方法 所有的顶层⽅法都可以在
*任何位置被直接调⽤，不⽤管包名路径，也不⽤创建实例
 *
 * */
private val TAG ="Helper"
fun doSomething(){
    Log.d(TAG,"doSomething")
}