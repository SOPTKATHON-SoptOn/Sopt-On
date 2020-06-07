package com.example.sopkathon.Activity

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sopkathon.*
import com.example.sopkathon.data.RequestLogin
import com.example.sopkathon.network.RequestLoginToServer
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(){

    val requestLoginToServer = RequestLoginToServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btncolorgreen="#68c85e"
        val btncolorgrey="#a7a7a7"

        et_id.textChangedListener {
            if (et_id.text.isNotEmpty() && et_pw.text.isNotEmpty())
                btn_login.setBackgroundColor(Color.parseColor(btncolorgreen))
            else
                btn_login.setBackgroundColor(Color.parseColor(btncolorgrey))
        }

        et_pw.textChangedListener {
            if (et_id.text.isNotEmpty() && et_pw.text.isNotEmpty())
                btn_login.setBackgroundColor(Color.parseColor(btncolorgreen))
            else
                btn_login.setBackgroundColor(Color.parseColor(btncolorgrey))
        }


        btn_login.setOnClickListener{
            if(et_id.text.isNullOrBlank() || et_pw.text.isNullOrBlank()){
                showToast("아이디와 비밀번호를 확인하세요.")
            }else {
                requestLoginToServer.service.requestLogin(
                    RequestLogin(
                        user_id = et_id.text.toString(),
                        password = et_pw.text.toString()
                    )
                ).customEnqueue(
                    onError = { showToast("올바르지 못한 요청입니다")},
                    onSuccess = {
                        if(it.success){
                            if(check1.isChecked()) {
                                startActivity<MainActivity>()
                                finish()
                            }
                            else
                                startActivity<AnswerActivity>()
                        }else {
                            showToast("아이디와 비밀번호를 확인하세요.")
                        }
                    }
                )
            }
        }

        tv_register.setOnClickListener {
            startActivity<RegisterActivity>()
        }
    }
}