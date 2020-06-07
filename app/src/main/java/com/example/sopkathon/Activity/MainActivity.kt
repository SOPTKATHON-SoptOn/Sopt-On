package com.example.sopkathon.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sopkathon.R
import com.example.sopkathon.startActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        green_button.setOnClickListener(){
            startActivity<AnswerAdminActivity>()
        }

        check_button.setOnClickListener(){
            startActivity<CheckAdminActivity>()
        }
    }
}
