package com.alpesh1.user_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    lateinit var reference: DatabaseReference
    lateinit var newsArrayList: ArrayList<UserModel>
    lateinit var newsRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsRecycler = findViewById(R.id.newsRecyclerView)
        newsRecycler.layoutManager = LinearLayoutManager(this)
        newsRecycler.setHasFixedSize(true)

        newsArrayList = arrayListOf()

        getNewsData()

    }

    private fun getNewsData() {

        reference = FirebaseDatabase.getInstance().getReference("IndiaNews")

        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {

                    for (newssnapshot in snapshot.children) {

                        var news = newssnapshot.getValue(UserModel::class.java)

                        newsArrayList.add(news!!)

                    }

                    newsRecycler.adapter = NewsAdapter(newsArrayList)

                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

    }
}