package com.example.sopkathon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_check_admin.*

class CheckAdminActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_admin)

        recyclerView.adapter = RecyclerAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)


    }

}