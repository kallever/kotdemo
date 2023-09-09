package com.example.myapplication.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    val TAG = "MyReceiver"
    override fun onReceive(context: Context, intent: Intent) {
        Log.d(TAG,"received in MyBroadcastReceiver")
        Toast.makeText(context, "received in MyBroadcastReceiver",
            Toast.LENGTH_SHORT).show()
    }
}