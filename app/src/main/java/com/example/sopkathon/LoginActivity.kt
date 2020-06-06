package com.example.sopkathon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sopkathon.data.RequestLogin
import com.example.sopkathon.network.RequestLoginToServer
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(){

    val requestLoginToServer = RequestLoginToServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

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