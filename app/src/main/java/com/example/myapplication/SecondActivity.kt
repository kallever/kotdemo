package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.base.BaseActivity
import kotlinx.android.synthetic.main.activity_second.*
import util.ActivityCollector

class SecondActivity : BaseActivity() {
    private val TAG ="SecondActivity"

    companion object{
        //模仿静态方法，给其他调用，这样别人就不需要管键值对的问题，直接传值就行了

        @JvmStatic//这才是真正的静态方法，注解只能加在单例类或companion object中的⽅法上
        fun actionStart(context: Context,data1:String,data2:String){
            val intent = Intent(context, SecondActivity::class.java).apply {
                putExtra("param1", data1)
                putExtra("param2", data2)
            }
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d(TAG,"onCreate")
        val param1 = intent.getStringExtra("param1")
        val param2 = intent.getStringExtra("param2")

        Log.d(TAG,"param1 is $param1,param2 is $param2")

        close.setOnClickListener {

            ActivityCollector.finishAll()
        }
    }

    override fun onBackPressed() {
        Log.d(TAG,"onBackPressed")
        val intent = Intent()
        intent.putExtra("data_return","hello first")
        setResult(RESULT_OK,intent)
        finish()
    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"onRestart")
    }

}