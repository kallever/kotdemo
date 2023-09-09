package com.example.myapplication.broadcast

import android.app.AlertDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import util.ActivityCollector

//priority设为100，优先处理
//由于广播，可以使用abortBroadcast截断，不让后续的广播收到信号
//静态广播不能做UI
class MyAnothorReceiver : BroadcastReceiver() {
    val TAG = "MyAnothorReceiver"
    override fun onReceive(context: Context, intent: Intent) {
        Log.d(TAG,"received in MyAnothorReceiver "+Thread.currentThread().name)
        Toast.makeText(context, "received in MyAnothorReceiver",
            Toast.LENGTH_SHORT).show()
        abortBroadcast()

//        AlertDialog.Builder(context).apply {
//            setTitle("waring")
//            setMessage("offline")
//            setCancelable(false)
//            setPositiveButton("OK"){
//                    _,_ ->
//                ActivityCollector.finishAll();
//
//            }
//            show()
//        }
    }
}