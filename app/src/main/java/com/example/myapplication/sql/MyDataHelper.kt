package com.example.myapplication.sql

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import com.example.myapplication.fragment.TwoFragment

class MyDataHelper(val context: Context,name:String,version:Int):SQLiteOpenHelper(context,name,null,version) {

    private val TAG = "MyDataHelper"
    private val createBook = "create table Book (" +
            " id integer primary key autoincrement," +
            "author text," +
            "price real," +
            "pages integer," +
            "name text,"+"category_id integer)"
    private val createCategory = "create table Category (" +
            "id integer primary key autoincrement," +
            "category_name text," +
            "category_code integer)"
    private val test = "create table Test (" +
            "id integer primary key autoincrement," +
            "category_name text," +
            "category_code integer)"
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(createBook)
        p0?.execSQL(createCategory)
        p0?.execSQL(test)
        Toast.makeText(context, "Create succeeded",
            Toast.LENGTH_SHORT).show()

    }

    override fun onUpgrade(p0: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.d(TAG,"onUpgrade oldVersion=$oldVersion newVersion=$newVersion")
//        p0?.execSQL("drop table if exists Book")
//        p0?.execSQL("drop table if exists Category")
//        onCreate(p0)
        if(oldVersion<=4){
            p0?.execSQL(test)
            p0?.execSQL("alter table Book add column category_id integer")
        }
    }


    fun insert(db: SQLiteDatabase){
        db.execSQL("insert into Book (name, author, pages, price) values(?, ?,?, ?)",
        arrayOf("The Da Vinci Code", "Dan Brown", "454", "16.96")
        )
        db.execSQL("insert into Book (name, author, pages, price) values(?, ?,?, ?)",
        arrayOf("The Lost Symbol", "Dan Brown", "510", "19.95")
        )
    }

    fun update(db: SQLiteDatabase){
        db.execSQL("update Book set price = ? where name = ?", arrayOf("10.99",
            "The Da Vinci Code"))
    }

    fun delete(db: SQLiteDatabase){
        db.execSQL("delete from Book where pages > ?", arrayOf("500"))
    }

    @SuppressLint("Range")
    fun query(db:SQLiteDatabase){
        val cursor = db.rawQuery("select * from Book", null)
        if(cursor?.moveToFirst() == true){
            do{
                val name = cursor.getString(cursor.getColumnIndex("name"))
                val author =
                    cursor.getString(cursor.getColumnIndex("author"))
                val pages =
                    cursor.getInt(cursor.getColumnIndex("pages"))
                val price =
                    cursor.getDouble(cursor.getColumnIndex("price"))
                Log.d(TAG, "book name is $name")
                Log.d(TAG, "book author is $author")
                Log.d(TAG, "book pages is $pages")
                Log.d(TAG, "book price is $price")

            }while (cursor.moveToNext())
        }
        cursor.close()
    }
}