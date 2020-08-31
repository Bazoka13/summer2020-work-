package com.example.oj4thinhand

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        initView()
    }
    private fun initView() {

    }
    //Called when user click on the Problem button
    fun watchProblem(view: View){
        val intent=Intent(this,ProblemActivity::class.java).apply {  }
        startActivity(intent);
    }
    public fun watchDetail(view: View){

    }
    //Called when user click on the Tutorial button
    fun watchTutorial(view: View){
        val intent=Intent(this,TutorialActivity::class.java).apply {  }
        startActivity(intent);
    }
    //Called when user click on the Community button
    fun watchCommunity(view: View){
        val intent=Intent(this,CommunityActivity::class.java).apply {  }
        startActivity(intent);
    }
    //Called when user click on the Account button
    fun watchAccount(view: View){
        val intent=Intent(this,AccountActivity::class.java).apply {  }
        startActivity(intent);
    }
}