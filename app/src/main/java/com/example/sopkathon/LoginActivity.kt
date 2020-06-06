package com.example.sopkathon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(){
    val requestCode = 2026

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener() {
            if (et_id.text.isNullOrBlank() || et_pw.text.isNullOrBlank()) {
                showToast("아이디와 비밀번호를 확인하세요.")
            }
            else
                startActivity<MainActivity>()
        }

        tv_register.setOnClickListener {
            startActivity<RegisterActivity>()
        }
    }
}