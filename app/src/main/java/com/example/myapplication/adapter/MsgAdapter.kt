package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.bean.Msg
import com.example.myapplication.listener.LeftViewHolder
import com.example.myapplication.listener.RightViewHolder

class MsgAdapter(val msgList: List<Msg>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        if(viewType == Msg.TYPE_RECEIVED){
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.msg_left_item,
                    parent, false)
            LeftViewHolder(view)

        } else {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.msg_right_item,
                    parent, false)
            RightViewHolder(view)
        }


    override fun getItemCount(): Int {
        return msgList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val msg = msgList[position]
        when(holder){
            is LeftViewHolder -> holder.leftMsg.text = msg.content
            is RightViewHolder -> holder.rightMsg.text = msg.content
        }
    }

    override fun getItemViewType(position: Int): Int {
        val msg = msgList[position]
        return msg.type
    }
}