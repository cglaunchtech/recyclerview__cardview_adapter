package com.example.cardview_recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import coil.load


class SecondActivity : AppCompatActivity() {

    lateinit var homeBtn: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        homeBtn = findViewById(R.id.home_btn)

        val first = intent.getStringExtra("first")
        val last = intent.getStringExtra("last")
        val userName = intent.getStringExtra("userName")
        val age = intent.getIntExtra("age", 0)
        val aboutMe = intent.getStringExtra("about")
        val image = intent.getStringExtra("image")

        val user = User(
            first.toString(),
            last.toString(),
            userName.toString(),
            age,
            aboutMe.toString(),
            image.toString()
        )

        populate(user)

        homeBtn.setOnClickListener {
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }

    }

    fun populate(user: User){

        val firstN: TextView = findViewById(R.id.first)
        val lastN: TextView = findViewById(R.id.last)
        val userN: TextView = findViewById(R.id.userName)
        val ageN: TextView = findViewById(R.id.age)
        val aboutN: TextView = findViewById(R.id.about)
        val imageN: ImageView = findViewById(R.id.image)

        firstN.text = user.firstName
        lastN.text = user.lastName
        userN.text = user.userName
        ageN.text = user.age.toString()
        aboutN.text = user.aboutMe
        imageN.load(user.image)

    }

}