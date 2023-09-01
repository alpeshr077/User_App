package com.alpesh1.user_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    lateinit var reference : DatabaseReference
    lateinit var newsArryList : ArrayList<UserModel>
    lateinit var newsRecycler : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        newsRecycler = findViewById(R.id.newsRecyclerView)
        newsRecycler.layoutManager = LinearLayoutManager(this)
        newsRecycler.setHasFixedSize(true)

        newsArryList = arrayListOf()

        getNewsData()
//        getImages()

    }

//    private fun getImages() {
//
//        reference = FirebaseDatabase.getInstance().getReference("User")
//
//        reference.addValueEventListener(object : ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//
//                if (snapshot.exists()){
//
//                    for (newssnapshot in snapshot.children){
//
//                        var news = newssnapshot.getValue(UserModel::class.java)
//
//                        newsArryList.add(news!!)
//
//                    }
//
//                    newsRecycler.adapter = NewsAdapter(newsArryList)
//
//                }
//
//
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//
//            }
//
//
//        })
//
//
//    }

    private fun getNewsData() {

        reference = FirebaseDatabase.getInstance().getReference("User")

        reference.addValueEventListener(object : ValueEventListener{
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