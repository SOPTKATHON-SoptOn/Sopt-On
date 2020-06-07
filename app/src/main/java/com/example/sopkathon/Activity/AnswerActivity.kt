package com.example.sopkathon.Activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sopkathon.R
import com.example.sopkathon.network.RequestLoginToServer
import com.example.sopkathon.network.RequestToServer
import com.example.sopkathon.showToast
import com.example.sopkathon.startActivity
import kotlinx.android.synthetic.main.activity_answer.*

class AnswerActivity : AppCompatActivity() {

    val requestLoginToServer = RequestLoginToServer
    val requestToServer = RequestToServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        btn_submit.setOnClickListener() {
            btn_submit.setBackgroundResource(R.drawable.round_green)
            btn_submit.setTextColor(Color.WHITE)

            if(et_answer.text.isNullOrBlank()){
                showToast("입력한 사항을 확인해 주세요.")
            } else {
                startActivity<CheckAdminActivity>()
            }
        }
    }
}