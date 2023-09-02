package com.alpesh1.user_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Business_News : AppCompatActivity() {

    lateinit var reference : DatabaseReference
    lateinit var newsArryList : ArrayList<UserModel>
    lateinit var newsRecycler : RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_business_news)

        newsRecycler = findViewById(R.id.newsRecyclerView)
        newsRecycler.layoutManager = LinearLayoutManager(this)
        newsRecycler.setHasFixedSize(true)

        newsArryList = arrayListOf()

        getNewsData()

    }

    private fun getNewsData() {

        reference = FirebaseDatabase.getInstance().getReference("BusinessNews")

        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){

                    for (newssnapshot in snapshot.children){

                        var news = newssnapshot.getValue(UserModel::class.java)

                        newsArryList.add(news!!)

                    }

                    newsRecycler.adapter = NewsAdapter(newsArryList)

                }

            }

            override fun onCancelled(error: DatabaseError) {


            }

        })

    }

}