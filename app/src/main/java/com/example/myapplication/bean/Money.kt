package com.example.myapplication.bean

class Money(val value:Int) {
    operator fun plus(money: Money):Money{
        val sum = value + money.value
        return Money(sum)
    }

    operator fun plus(money: Int):Money{
        val sum = value + money
        return Money(sum)
    }
}