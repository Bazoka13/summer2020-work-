package com.example.oj4thinhand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

open class AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
    }
    fun watchTreasure(view: View){
        val intent=Intent(this,TreasureActivity::class.java).apply {}
        startActivity(intent)
    }
    fun watchTopic(view: View){
        val intent=Intent(this,TopicActivity::class.java).apply {}
        startActivity(intent)
    }
    fun logOut(view:View){
        val intent=Intent(this,MainActivity::class.java).apply {  }
        startActivity(intent)
    }
}