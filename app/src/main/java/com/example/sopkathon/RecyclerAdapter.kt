package com.example.sopkathon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class RecyclerAdapter:RecyclerView.Adapter<RecyclerAdapter.MainViewHolder>(){

    var items: MutableList<PeopleItem> = mutableListOf(PeopleItem("박지혜", "오후 14시 10분 출석"),
        PeopleItem("이주현", "오후 14시 00분 출석"),PeopleItem("정현지", "오후 13시 26분 출석"),
        PeopleItem("김영민", "오후 13시 13분 출석"),PeopleItem("정효원", "오후 12시 58분 출석"))

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