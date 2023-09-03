package com.example.myapplication.View

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import com.example.myapplication.R
import kotlinx.android.synthetic.main.title.view.*

class TitleLayout(context:Context,attrs:AttributeSet) :LinearLayout(context, attrs){
    init {
        LayoutInflater.from(context).inflate(R.layout.title,this,)
        back.setOnClickListener {
            val activity = context as Activity//强转
            activity.finish()
        }

        more.setOnClickListener {
            Toast.makeText(context,"more",Toast.LENGTH_SHORT).show()
        }
    }
}