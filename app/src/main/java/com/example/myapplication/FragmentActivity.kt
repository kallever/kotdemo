package com.example.myapplication

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.bean.Money
import com.example.myapplication.broadcast.MyBroatcast
import com.example.myapplication.fragment.OneFragment
import com.example.myapplication.fragment.ThreeFragment
import com.example.myapplication.fragment.TwoFragment
import kotlinx.android.synthetic.main.activity_fragment.*
import kotlinx.android.synthetic.main.fragment_one.*
import util.lettersCount

class FragmentActivity : AppCompatActivity() {
    private val TAG="FragmentActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val fragment = leftFrag as OneFragment
        val isTwoPane = findViewById<View>(R.id.rightLayout) != null

        fragment.button.setOnClickListener {
//            if(isTwoPane) {
//                replaceFragment(ThreeFragment())
//            }else{
//                Toast.makeText(applicationContext, "呜呜呜呜呜",Toast.LENGTH_SHORT).show()
//            }
            send()
        }
        if(isTwoPane)
            replaceFragment(TwoFragment())
//        var str = "sdsdsdsdsdsd121212124343".lettersCount()
//        Log.d(TAG,"str$str")
//
//        addObj()
//        register()
    }
    lateinit var timeChange:MyBroatcast

    //显示广播
    fun send(){
        val intent = Intent("com.example.broadcasttest.MY_BROADCAST")
        intent.setPackage(packageName)
//        sendBroadcast(intent)
        sendOrderedBroadcast(intent,null)//发送有序广播
    }

    //动态注册
    fun register(){
        val intentFilter= IntentFilter()
        intentFilter.addAction("android.intent.action.TIME_TICK")
        timeChange = MyBroatcast()
        registerReceiver(timeChange,intentFilter)
    }

    private fun addObj(){
        val money1=Money(5)
        val money2=Money(10)
        val money3 = (money2+money1)
        val money4 = money3 + 20
        Log.d(TAG, money4.value.toString())
    }


    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.rightLayout, fragment)
//        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun get():String{
        return "FragmentActivity111"
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChange)
    }
}