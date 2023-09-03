package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.base.BaseActivity
import kotlinx.android.synthetic.main.activity_first.*
import util.doSomething

class FirstActivity :BaseActivity(){
    private val TAG ="FirstActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        Log.d(TAG,"onCreate")
        button.setOnClickListener {
//            showToast()
//            finish()
            jump2two()
        }

        jump.setOnClickListener {
//            jump22()
//            url()
//            del()
            jump2dialog()
        }

        if(savedInstanceState!=null){
            val temp = savedInstanceState.getString("data_key")
            Log.d(TAG,"temp is $temp")
        }

        test.setOnClickListener {
//            testApply()
            doSomething()
            showDialog()
        }
    }

    private fun showDialog(){
        AlertDialog.Builder(this).apply {
            setTitle("This is DIalog")
            setMessage("important")
            setCancelable(false)
            setPositiveButton("OK"){
                    _, _ ->
            }
            setNegativeButton("Cancel"){
                    _, _ ->
            }
            show()
        }
    }

    private fun testWith(){
        val list= listOf("Apple","Banana", "Orange", "Pear", "Grape")

        val result = with(java.lang.StringBuilder()){
            append("start eat fruits \n")
            for (fruit in list){
                append(fruit).append("\n")
            }
            append("Ate all fruits.")
            toString()
        }
        Log.d(TAG,result)
    }

    //with 和 run 返回最后指定返回值
    private fun testRun(){
        val list= listOf("Apple","Banana", "Orange", "Pear", "Grape")

        val result = StringBuilder().run{
            append("start eat fruits \n")
            for (fruit in list){
                append(fruit).append("\n")
            }
            append("Ate all fruits.")
            toString()
        }
        Log.d(TAG,result)
    }

    //apply 返回对象本身
    private fun testApply(){
        val list= listOf("Apple","Banana", "Orange", "Pear", "Grape")

        val result = StringBuilder().apply{
            append("start eat fruits \n")
            for (fruit in list){
                append(fruit).append("\n")
            }
            append("Ate all fruits.")
        }
        Log.d(TAG,result.toString())
    }

    private fun jump2dialog() {
        val intent = Intent(this,DialogActivity::class.java)
        startActivity(intent)
    }

    private fun showToast(str:String = "test"){
        Toast.makeText(this,"click $str",Toast.LENGTH_SHORT).show()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.add_item -> showToast("Add")
            R.id.remove_item -> showToast("Remove")
        }
        return super.onOptionsItemSelected(item)
    }

    //显式intent
    private fun jump2two(){
        val data = "hello  second"
        SecondActivity.actionStart(this,"test1","test2")
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val returnedData = data?.getStringExtra("data_return")
                Log.d(TAG, "returned data is $returnedData")
            }
        }

    }

    //隐式
    private fun jump22(){
        val intent = Intent("com.example.activitytest.ACTION_START")
        intent.addCategory ( "android.intent.category.SecondActivity")
        startActivity(intent)
    }

    private fun url(){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.baidu.com")
        startActivity(intent)
    }

    private fun del(){
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:10086")
        startActivity(intent)
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val tempdata = "temp"
        outState.putString("data_key",tempdata)
    }
}