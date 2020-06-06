package com.example.sopkathon

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.sopkathon.data.RequestCheck
import com.example.sopkathon.data.RequestLogin
import com.example.sopkathon.network.RequestLoginToServer
import com.example.sopkathon.network.RequestToServer
import kotlinx.android.synthetic.main.activity_answer.*
import kotlinx.android.synthetic.main.activity_answer_admin.*
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*

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