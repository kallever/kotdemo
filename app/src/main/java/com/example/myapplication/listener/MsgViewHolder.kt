package com.example.myapplication.listener

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

//密封类 密封类及其所
//有⼦类只能定义在同⼀个⽂件的顶层位置，不能嵌套在其他类中，这是被
//密封类底层的实现机制所限制的
sealed class MsgViewHolder(view: View):RecyclerView.ViewHolder(view)
class LeftViewHolder(view: View) :MsgViewHolder(view){
    val leftMsg: TextView = view.findViewById(R.id.leftMsg)
}
class RightViewHolder(view: View) :MsgViewHolder(view){
    val rightMsg: TextView = view.findViewById(R.id.rightMsg)
}

fun getResultMsg(result:MsgViewHolder) = when(result){
    is LeftViewHolder -> result.leftMsg
    is RightViewHolder -> result.rightMsg
}
