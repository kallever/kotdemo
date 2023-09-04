package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.myapplication.adapter.FruitAdapter
import com.example.myapplication.adapter.FruitAdapter2
import com.example.myapplication.bean.Fruit
import kotlinx.android.synthetic.main.activity_list.*
import util.times

class ListActivity : AppCompatActivity() {

    private var fruitList = ArrayList<Fruit>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


        fruitList = ArrayList<Fruit>().apply {
            repeat(2) {
                add(Fruit(getRandomLength("Apple"), "1"))
                add(Fruit(getRandomLength("Banana"), "1"))
                add(Fruit(getRandomLength("Orange"), "1"))
                add(Fruit(getRandomLength("Watermelon"), "1"))
                add(Fruit(getRandomLength("Pear"), "1"))
                add(Fruit(getRandomLength("Grape"), "1"))
                add(Fruit(getRandomLength("Pineapple"), "1"))
                add(Fruit(getRandomLength("Strawberry"), "1"))
            }

        }
        initListView()
      initRecycleView()
    }

    private fun initListView(){
        val adapter = FruitAdapter(this, R.layout.fruit_item, fruitList)
        listview.adapter = adapter

        listview.setOnItemClickListener { adapterView, view, position, l ->
            run {
                val fruit = fruitList[position]
                Toast.makeText(this, fruit.name1, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initRecycleView(){
//        val layoutManager =LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        val layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        recycle.layoutManager=layoutManager
        val adapter = FruitAdapter2(fruitList)
        recycle.adapter = adapter
    }

    private fun getRandomLength(str:String):String{
        val n = (1..20).random()
        return  str.times(n)
    }
}