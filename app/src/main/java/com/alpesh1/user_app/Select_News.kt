package com.alpesh1.user_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Select_News : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_news)


        var btnIndia = findViewById<TextView>(R.id.newsIndia)
        var btnBusiness = findViewById<TextView>(R.id.NewsBusiness)

        btnIndia.setOnClickListener {

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()

        }

        btnBusiness.setOnClickListener {

            val intent = Intent(this,Business_News::class.java)
            startActivity(intent)
            finish()

        }

    }
}