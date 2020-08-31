package com.example.oj4thinhand
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONException
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL


class ProblemActivity : AppCompatActivity() {
    private val strings = arrayOf(
        "1001",
        "1002",
        "1003",
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "11",
        "12",
        "13",
        "14",
        "15",
        "16",
        "17"
    )
    fun toProblemDetail(ID: Int){
        val intent=Intent(this,TutorialActivity::class.java).apply {  }
        startActivity(intent)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problem)
        val listView: ListView = findViewById(R.id.listview)
        listView.adapter = ArrayAdapter<Any?>(this, android.R.layout.simple_list_item_1, strings)
        listView.isTextFilterEnabled = true
        listView.onItemClickListener = OnItemClickListener { parent: AdapterView<*>?, view:View, position:Int, id:Long -> toProblemDetail(position) }
        val searchView: SearchView = findViewById(R.id.problemSearch)
        //为该SearchView组件设置事件监听器
        //为该SearchView组件设置事件监听器
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            //单机搜索按钮时激发该方法
            override fun onQueryTextSubmit(query: String): Boolean {
                //实际应用中应该在该方法内执行实际查询，此处仅使用Toast显示用户输入的查询内容
                Toast.makeText(this@ProblemActivity, "你要搜索的是：" + query, Toast.LENGTH_SHORT).show();
                return false
            }
            //用户输入字符时激发该方法
            override fun onQueryTextChange(newText: String?): Boolean {
                //如果newText不是长度为0的字符串
                if (TextUtils.isEmpty(newText)) {
                    //清除ListView的过滤
                    listView.clearTextFilter()
                } else {
                    //使用用户输入的内容对ListView的列表项进行过滤
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
    fun callProblem(view: View){
        val intent=Intent(this, ProblemDetailActivity::class.java).apply {}
        startActivity(intent)
    }

}