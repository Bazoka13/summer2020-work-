package com.example.oj4thinhand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }
    //Called when user click on the Problem button
    fun watchProblem(view: View){
        val intent = Intent(this, ProblemActivity::class.java).apply {
        }
        startActivity(intent)
    }
    //Called when user click on the Tutorial button
    fun watchTutorial(view: View){
        val intent = Intent(this, TutorialActivity::class.java).apply {
        }
        startActivity(intent)
    }
    //Called when user click on the Community button
    fun watchCommunity(view: View){
        val intent = Intent(this, CommunityActivity::class.java).apply {
        }
        startActivity(intent)
    }
    //Called when user click on the Account button
    fun watchAccount(view: View){
        val intent = Intent(this, AccountActivity::class.java).apply {
        }
        startActivity(intent)
    }
}