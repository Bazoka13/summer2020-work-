package com.example.oj4thinhand

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_problem_detail.*
import kotlinx.android.synthetic.main.listview_style_1.*
import java.net.HttpURLConnection
import java.net.URL

class ProblemDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problem_detail)
        val i=intent
        val ID=i.getIntExtra("id",1)
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
}