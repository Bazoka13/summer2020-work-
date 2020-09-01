package com.example.oj4thinhand

import android.annotation.SuppressLint
import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.net.HttpURLConnection
import java.net.URL

class ProblemDetailActivity : AppCompatActivity() {
    private val strings = arrayOf(
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
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problem_detail)
        val i=intent
        val ID=i.getIntExtra("id", 1)
        val Name=i.getStringExtra("name")
        val ttmp=findViewById<TextView>(R.id.problemTitle)
        ttmp.text=Name
        Thread{
            val string=getHTTP(ID)
            this.runOnUiThread{
                val tmp=findViewById<TextView>(R.id.detail)
                tmp.text=string
            }
        }.start()
        val tmp:MyApplication= applicationContext as MyApplication
        val tre=findViewById<TextView>(R.id.Treasure)
        val but=findViewById<FloatingActionButton>(R.id.miniFab06)
        if(tmp.vis.contains(ID)){
            tre.text="取消收藏"
        }else{
            tre.text="加入收藏"
        }
        but.setOnClickListener { v ->
            if (tmp.vis.contains(ID)) {
                if (v != null) {
                    deleteTreasure(v)
                }
            } else {
                if (v != null) {
                    AddTreasure(v)
                }
            }
        }
    }
    fun getHTTP(ID: Int):String{
        val url = URL("https://accoding-cn-443.e2.buaa.edu.cn/problem/$ID/index")
        val connection = url.openConnection() as HttpURLConnection
        connection.let {
            it.requestMethod = "GET"
            it.connectTimeout = 8000
            it.readTimeout = 8000
            // 设置请求参数的格式
            // application/json;charset=UTF-8  为JSON格式
            // application/x-www-form-urlencoded  为表单格式
        }
        connection.connect()
        val code = connection.responseCode
        // 根据响应码获取不同输入流
        val inStream = if (code == 200)
            connection.inputStream
        else
            connection.errorStream
        val result = inStream.bufferedReader().lineSequence().joinToString()
        connection.disconnect()
        return result
    }
    var isAdd=false
    fun addMenu(view: View){
        val tmp=findViewById<RelativeLayout>(R.id.rlAddBill)
        if(isAdd){
         tmp.visibility=View.VISIBLE
        }else tmp.visibility=View.GONE
        isAdd=!isAdd
    }
    fun toTutorial(view: View){
        val i=intent
        val ID=i.getIntExtra("id", 1)
        val intent=Intent(this, TutorialDetailActivity::class.java).apply {  }
        intent.putExtra("id", ID)
        intent.putExtra("name", strings[ID])
        startActivity(intent)
    }
    fun AddTreasure(view: View){
        val i=intent
        val ID=i.getIntExtra("id", 1)
        val tmp:MyApplication= applicationContext as MyApplication
        tmp.vis.add(ID)
        val tre=findViewById<TextView>(R.id.Treasure)
        tre.text="取消收藏"
    }
    fun deleteTreasure(view: View){
        val i=intent
        val ID=i.getIntExtra("id", 1)
        val tmp:MyApplication= applicationContext as MyApplication
        if (tmp.vis.contains(ID))tmp.vis.remove(ID)
        val tre=findViewById<TextView>(R.id.Treasure)
        tre.text="加入收藏"
    }
}