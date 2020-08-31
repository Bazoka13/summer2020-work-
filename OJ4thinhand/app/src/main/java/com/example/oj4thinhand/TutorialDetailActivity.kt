package com.example.oj4thinhand

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.net.HttpURLConnection
import java.net.URL

class TutorialDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_detail)
        val i=intent
        val ID=i.getIntExtra("id",1)
        val Name=i.getStringExtra("name")
        val ttmp=findViewById<TextView>(R.id.tutorialTitle)
        ttmp.text=Name
        Thread{
            val string=getHTTP(ID)
            this.runOnUiThread{
                val tmp=findViewById<TextView>(R.id.tutorialDetail)
                tmp.text=string
            }
        }.start()
    }
    //这里由于学长只给我开了sid调用的api，所以只能手动添加sid对应关系了
    private val sid= arrayOf(
        "1397158",
        "1474639",
        "2377610",
        "2223124",
        "2224807",
        "2224702",
        "2224276",
        "1847432",
        "1827462",
        "1850000",
        "1830633",
        "2629241",
        "2743574",
        "2731987",
        "2731990",
        "2176975",
        "2732000",
        "1840417"
    )
    fun getHTTP(ID: Int):String{
        val url = URL("https://accoding-cn-443.e2.buaa.edu.cn/submission/$sid[$ID]/solution")
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