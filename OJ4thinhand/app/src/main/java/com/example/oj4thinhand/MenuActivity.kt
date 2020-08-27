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
        val one = ProblemFragment()
        if(one.activity!=null){
            val two = TutorialFragment()
            supportFragmentManager.beginTransaction().replace(R.id.index_content_fl,two).commit()
        } else supportFragmentManager.beginTransaction().replace(R.id.index_content_fl,one).commit()
    }
    //Called when user click on the Problem button
    fun watchProblem(view: View){
        val one = ProblemFragment()
        supportFragmentManager.beginTransaction().replace(R.id.index_content_fl,one).commit()

        val problems= arrayOf("1001","1002","1003")
        if(one.activity!=null){
            val two = TutorialFragment()
            supportFragmentManager.beginTransaction().replace(R.id.index_content_fl,two).commit()
        }
        val problemAdapter= one.activity?.let { ArrayAdapter(it,R.layout.fragment_problem,problems) }
        val problemFind= findViewById<AutoCompleteTextView>(R.id.problemSearch)

        if (problemFind != null) {
            problemFind.setAdapter(problemAdapter)

        }
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