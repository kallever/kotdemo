package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.MsgAdapter
import com.example.myapplication.bean.Msg
import kotlinx.android.synthetic.main.activity_msg.*

class MsgActivity : AppCompatActivity() {
    private val msgList = ArrayList<Msg>()
    private lateinit var adapter: MsgAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_msg)

        initMsg()

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        if(!::adapter.isInitialized) {
            adapter = MsgAdapter(msgList)
        }
        recyclerView.adapter = adapter

        send.setOnClickListener {
            val content = inputText.text.toString()
            if(content.isNotEmpty()){
                val msg = Msg(content, Msg.TYPE_SENT)
                msgList.add(msg)
                adapter.notifyItemInserted(msgList.size -1)
                recyclerView.scrollToPosition(msgList.size - 1)
                inputText.setText("")
            }
        }
    }

    private fun initMsg() {
        val msg1 = Msg("Hello guy.", Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("Hello. Who is that?", Msg.TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("This is Tom. Nice talking to you. ",
            Msg.TYPE_RECEIVED)
        msgList.add(msg3)
    }
}