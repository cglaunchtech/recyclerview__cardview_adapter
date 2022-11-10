package com.example.cardview_recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var userAdapter : Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerView : RecyclerView = findViewById(R.id.recyclerView)

        userAdapter =
            Adapter(this, { position -> onCardClick(position) })
        recyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL,
            false
        )
        recyclerView.adapter = userAdapter

    }

    private fun onCardClick(position: Int) {
        val myIntent = Intent(this, SecondActivity::class.java)
            myIntent.putExtra("first", userAdapter.userList[position].firstName)
            myIntent.putExtra("last", userAdapter.userList[position].lastName)
            myIntent.putExtra("userName", userAdapter.userList[position].userName)
            myIntent.putExtra("age", userAdapter.userList[position].age)
            myIntent.putExtra("about", userAdapter.userList[position].aboutMe)
            myIntent.putExtra("image", userAdapter.userList[position].image)
            startActivity(myIntent)
    }
}