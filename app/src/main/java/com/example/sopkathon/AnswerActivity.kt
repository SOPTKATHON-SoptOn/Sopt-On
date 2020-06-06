package com.example.sopkathon

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_answer.*
import kotlinx.android.synthetic.main.activity_answer_admin.*

class AnswerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        btn_submit.setOnClickListener() {
            btn_submit.setBackgroundResource(R.drawable.round_green)
            btn_submit.setTextColor(Color.WHITE)
        }
    }
}