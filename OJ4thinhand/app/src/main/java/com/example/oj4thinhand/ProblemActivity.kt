package com.example.oj4thinhand
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import org.json.JSONException
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL


class ProblemActivity : AppCompatActivity() {
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
    fun toProblemDetail(ID: Int){
        val intent=Intent(this, ProblemDetailActivity::class.java).apply {  }
        intent.putExtra("id", ID)
        intent.putExtra("name", strings[ID])
        startActivity(intent)
    }
    fun getInt(pos: Int): Int {
        val listView: ListView = findViewById(R.id.listview)
        var ans=0
        var cnt=0
        val s =listView.getItemAtPosition(pos) as String
        for (i in strings){
            if(i == s)ans=cnt
            cnt++
        }
        return ans
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problem)
        val listView: ListView = findViewById(R.id.listview)
        listView.adapter = ArrayAdapter<Any?>(this, R.layout.listview_style_1, strings)
        listView.isTextFilterEnabled = true
        listView.onItemClickListener = OnItemClickListener { parent: AdapterView<*>?, view: View, position: Int, id: Long -> toProblemDetail(
            getInt(
                position
            )
        ) }
        val searchView: SearchView = findViewById(R.id.problemSearch)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(this@ProblemActivity, "你要搜索的是：$query", Toast.LENGTH_SHORT)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (TextUtils.isEmpty(newText)) {
                    listView.clearTextFilter()
                } else {

                    listView.setFilterText(newText)
                }
                return true
            }
        })
    }
    fun get_key_string(key: String, jsonString: String):String {
        var str = ""
        try {
            val jsonObj= JSONObject(jsonString)
            str=jsonObj.getString(key)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return str
    }
    fun getHTTP(ID: String):String{
        val url = URL("https://www.baidu.com/")
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