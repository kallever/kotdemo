package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.adapter.FruitAdapter
import com.example.myapplication.bean.Fruit
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    private var fruitList = ArrayList<Fruit>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


        fruitList = ArrayList<Fruit>().apply {
            repeat(2) {
                add(Fruit("Apple", "1"))
                add(Fruit("Banana", "1"))
                add(Fruit("Orange", "1"))
                add(Fruit("Watermelon", "1"))
                add(Fruit("Pear", "1"))
                add(Fruit("Grape", "1"))
                add(Fruit("Pineapple", "1"))
                add(Fruit("Strawberry", "1"))
            }

        }

        val adapter = FruitAdapter(this, R.layout.fruit_item, fruitList)
        listview.adapter = adapter
    }
}