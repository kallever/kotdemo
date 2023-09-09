package com.example.myapplication.broadcast

import android.app.AlertDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import util.ActivityCollector

class MyBroatcast :BroadcastReceiver(){
    override fun onReceive(p0: Context?, p1: Intent?) {
        Log.d("jk","\"Time has changed\"" +Thread.currentThread().name)

        AlertDialog.Builder(p0).apply {
            setTitle("waring")
            setMessage("offline")
            setCancelable(false)
            setPositiveButton("OK"){
                _,_ ->
                    ActivityCollector.finishAll();

            }
            show()
        }
    }
}