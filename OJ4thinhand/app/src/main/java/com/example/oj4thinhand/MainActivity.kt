package com.example.oj4thinhand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun login(view:View):Boolean{
        return false
    }
    fun enterMenu(view:View){
        val intent=Intent(this,MenuActivity::class.java).apply {
        }
        startActivity(intent)
    }
}