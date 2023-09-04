package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.bean.Fruit

class FruitAdapter2(val fruitlist:List<Fruit>): RecyclerView.Adapter<FruitAdapter2.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val fruitImage: TextView = view.findViewById(R.id.fruitImage)
        val fruitName: TextView = view.findViewById(R.id.fruitName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fruit_item_2, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = fruitlist[position]
            Toast.makeText(parent.context, "you clicked view${fruit.name1}",Toast.LENGTH_SHORT).show()
        }
        viewHolder.fruitImage.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = fruitlist[position]
            Toast.makeText(parent.context, "you clicked image${fruit.name1}", Toast.LENGTH_SHORT).show()
        }
        return viewHolder
    }

    override fun getItemCount()=fruitlist.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitlist[position]
        holder.fruitImage.text=fruit.name2
        holder.fruitName.text=fruit.name1

    }
}