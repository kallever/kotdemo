package com.example.myapplication.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyBroatcast :BroadcastReceiver(){
    override fun onReceive(p0: Context?, p1: Intent?) {
        Log.d("jk","\"Time has changed\"")
    }
}