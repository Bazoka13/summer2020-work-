package com.example.oj4thinhand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*

class TreasureActivity : AppCompatActivity() {
    var strings:MutableList<String> = mutableListOf()
    fun toProblemD(ID: Int){
        val tmp:MyApplication= applicationContext as MyApplication
        val intent= Intent(this, ProblemDetailActivity::class.java).apply {  }
        intent.putExtra("id", ID)
        intent.putExtra("name", tmp.problemName[ID])
        startActivity(intent)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_treasure)
        val tmp:MyApplication= applicationContext as MyApplication
        for (i in tmp.vis){
            strings.add(tmp.problemName[i])
        }
        val nameTreasure:List<String> = strings
        val listView: ListView = findViewById(R.id.TreasureListview)
        listView.adapter = ArrayAdapter<Any?>(this, R.layout.listview_style_1, nameTreasure)
        listView.isTextFilterEnabled = true
        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent: AdapterView<*>?, view: View, position: Int, id: Long ->
                toProblemD(getInt(position))
            }
        val searchView: SearchView = findViewById(R.id.TreasureSearch)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(this@TreasureActivity, "你要搜索的是：$query", Toast.LENGTH_SHORT)
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
    fun getInt(pos: Int): Int {
        val tmp:MyApplication= applicationContext as MyApplication
        val listView: ListView = findViewById(R.id.TreasureListview)
        var ans=0
        var cnt=0
        val s =listView.getItemAtPosition(pos) as String
        for (i in tmp.problemName){
            if(i == s)ans=cnt
            cnt++
        }
        return ans
    }
}