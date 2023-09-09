package util

import android.content.ContentValues

fun cvof(vararg pairs: Pair<String,Any?>) =ContentValues().apply{
    for(pari in pairs){
        val key = pari.first
        val value = pari.second
        when(value){
            is Int -> put(key, value)
            is Long -> put(key, value)
            is Short -> put(key, value)
            is Float -> put(key, value)
            is Double -> put(key, value)
            is Boolean -> put(key, value)
            is String -> put(key, value)
            is Byte -> put(key, value)
            is ByteArray -> put(key, value)
            null -> putNull(key)
        }
    }
}