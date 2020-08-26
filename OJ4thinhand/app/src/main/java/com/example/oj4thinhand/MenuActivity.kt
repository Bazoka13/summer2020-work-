package com.example.oj4thinhand

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        initView()
    }
    private fun initView() {
        val one = ProblemFragment()
        supportFragmentManager.beginTransaction().replace(R.id.index_content_fl,one).commit()
    }
    //Called when user click on the Problem button
    fun watchProblem(view: View){
        val one = ProblemFragment()
        supportFragmentManager.beginTransaction().replace(R.id.index_content_fl,one).commit()
    }
    //Called when user click on the Tutorial button
    fun watchTutorial(view: View){
        val one = TutorialFragment()
        supportFragmentManager.beginTransaction().replace(R.id.index_content_fl,one).commit()
    }
    //Called when user click on the Community button
    fun watchCommunity(view: View){
        val one = CommunityFragment()
        supportFragmentManager.beginTransaction().replace(R.id.index_content_fl,one).commit()
    }
    //Called when user click on the Account button
    fun watchAccount(view: View){
        val one = AccountFragment()
        supportFragmentManager.beginTransaction().replace(R.id.index_content_fl,one).commit()
    }
}