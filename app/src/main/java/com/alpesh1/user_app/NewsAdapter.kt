package com.alpesh1.user_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(var newslist:ArrayList<UserModel>) : RecyclerView.Adapter<NewsAdapter.newsHolder>() {

    class newsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title : TextView = itemView.findViewById(R.id.txtTitle)
        val date : TextView = itemView.findViewById(R.id.txtDate)
        val des : TextView = itemView.findViewById(R.id.txtDes)
//        val content : TextView = itemView.findViewById(R.id.txtContent)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): newsHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.news_details,parent,false)

        return newsHolder(itemView)

    }

    override fun getItemCount(): Int {


        return newslist.size
    }

    override fun onBindViewHolder(holder: newsHolder, position: Int) {

        val newsitem = newslist[position]

        holder.title.text = newsitem.title
        holder.date.text = newsitem.date
        holder.des.text = newsitem.des
//        holder.content.text = newsitem.content



    }

}