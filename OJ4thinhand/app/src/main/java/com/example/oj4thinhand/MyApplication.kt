package com.example.oj4thinhand

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.net.HttpURLConnection
import java.net.URL
open class MyApplication : Application(){
   open var vis:MutableList<Int> = mutableListOf()
   open val problemName = arrayOf(
        "1 test a+b   ",
        "2 求余   ",
        "3 BlueFly发糖了   ",
        "4 Kevin·Feng的正确@姿势   ",
        "5  jhljx上小学   ",
        "6 三位数反转   ",
        "7 Last_Day's dog   ",
        "8 creeper学妹的计算题   ",
        "9 零崎的人间冒险Ⅰ   ",
        "10 零崎的人间冒险Ⅱ   ",
        "11 Let's play a game    ",
        "12 零崎的人间冒险Ⅲ   ",
        "14 Inverse number：Reborn   ",
        "15 零崎的人间冒险Ⅳ   ",
        "17 A+B   ",
        "18 快来快来帮猪脚   ",
        "19 大家快来刷TD啊   ",
        "20 水水哒a+b   ",
        "21 大家都来分级啦   ",
        "22 公公偏头痛   "
    )
}