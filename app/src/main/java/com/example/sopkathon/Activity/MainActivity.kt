package com.example.sopkathon.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sopkathon.R
import com.example.sopkathon.startActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = getIntent()
        val checked = intent.getBooleanExtra("check", false)

        if(checked) check_button.setText("파트원 출석 명단 확인하기")
        else check_button.setText("나의 출석 내역 확인하기")

        green_button.setOnClickListener(){
            if(checked) startActivity<AnswerAdminActivity>()
            else startActivity<AnswerActivity>()
        }

        check_button.setOnClickListener(){
            if(checked) startActivity<CheckAdminActivity>()
            else startActivity<AnswerActivity>()
        }
    }
}
