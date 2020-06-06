package com.example.sopkathon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class RecyclerAdapter:RecyclerView.Adapter<RecyclerAdapter.MainViewHolder>(){

    var items: MutableList<PeopleItem> = mutableListOf(PeopleItem("Title1", "Content1"),
        PeopleItem("Title2", "Content2"),PeopleItem("Title3", "Content3"))

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = MainViewHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holer: MainViewHolder, position: Int) {
        items[position].let { item ->
            with(holer) {
                itemname.text = item.title
                itemtime.text = item.content
            }
        }
    }

    inner class MainViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)) {
        val itemname = itemView.main_title
        val itemtime = itemView.main_content
    }
}