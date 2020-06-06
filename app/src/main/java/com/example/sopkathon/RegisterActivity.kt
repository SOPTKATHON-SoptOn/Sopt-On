package com.example.sopkathon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.sopkathon.data.RequestRegister
import com.example.sopkathon.network.RequestRegisterToServer
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    val requestToServer = RequestRegisterToServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        bt_complete.setOnClickListener() {
            if (ed_id.text.isNullOrBlank() || ed_password.text.isNullOrBlank() || ed_name.text.isNullOrBlank() || ed_birthday.text.isNullOrBlank()) {
                showToast("가입 정보를 확인하세요")
            }   else {
                requestToServer.service.requestRegister(
                    RequestRegister(
                        name = ed_name.text.toString(),
                        birthday = ed_birthday.text.toString(),
                        id = ed_id.text.toString(),
                        password = ed_password.text.toString()
                    )
                ).customEnqueue(
                    onError = { showToast("올바르지 못한 요청입니다")},
                    onSuccess = {
                        if(it.success){
                            showToast("회원가입 성공")
                            startActivity<MainActivity>()
                            finish()
                        }else {
                            showToast("가입 정보를 확인하세요.")
                        }
                    }
                )
            }
        }
    }
}
