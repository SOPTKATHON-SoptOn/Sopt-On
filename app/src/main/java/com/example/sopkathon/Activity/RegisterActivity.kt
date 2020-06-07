package com.example.sopkathon.Activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sopkathon.*
import com.example.sopkathon.data.RequestRegister
import com.example.sopkathon.network.RequestRegisterToServer
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    val requestToServer = RequestRegisterToServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btncolorgreen="#68c85e"
        val btncolorgrey="#a7a7a7"

        ed_name.textChangedListener {
            if (ed_name.text.isNotEmpty() && ed_id.text.isNotEmpty() && ed_pw.text.isNotEmpty() && ed_birthday.text.isNotEmpty())
                btn_complete.setBackgroundColor(Color.parseColor(btncolorgreen))
            else
                btn_complete.setBackgroundColor(Color.parseColor(btncolorgrey))
        }
        ed_id.textChangedListener {
            if (ed_name.text.isNotEmpty() && ed_id.text.isNotEmpty() && ed_pw.text.isNotEmpty() && ed_birthday.text.isNotEmpty())
                btn_complete.setBackgroundColor(Color.parseColor(btncolorgreen))
            else
                btn_complete.setBackgroundColor(Color.parseColor(btncolorgrey))
        }
        ed_pw.textChangedListener {
            if (ed_name.text.isNotEmpty() && ed_id.text.isNotEmpty() && ed_pw.text.isNotEmpty() && ed_birthday.text.isNotEmpty())
                btn_complete.setBackgroundColor(Color.parseColor(btncolorgreen))
            else
                btn_complete.setBackgroundColor(Color.parseColor(btncolorgrey))
        }
        ed_birthday.textChangedListener {
            if (ed_name.text.isNotEmpty() && ed_id.text.isNotEmpty() && ed_pw.text.isNotEmpty() && ed_birthday.text.isNotEmpty())
                btn_complete.setBackgroundColor(Color.parseColor(btncolorgreen))
            else
                btn_complete.setBackgroundColor(Color.parseColor(btncolorgrey))
        }


        btn_complete.setOnClickListener() {
            if (ed_id.text.isNullOrBlank() || ed_pw.text.isNullOrBlank() || ed_name.text.isNullOrBlank() || ed_birthday.text.isNullOrBlank()) {
                showToast("가입 정보를 확인하세요")
            }   else {
                requestToServer.service.requestRegister(
                    RequestRegister(
                        user_name = ed_name.text.toString(),
                        user_birth = ed_birthday.text.toString(),
                        user_id = ed_id.text.toString(),
                        password = ed_pw.text.toString(),
                        user_fn = ybob_spinner.toString(),
                        user_part = part_spineer.toString(),
                        user_score = ""
                    )
                ).customEnqueue(
                    onError = { showToast("올바르지 못한 요청입니다")},
                    onSuccess = {
                        if(it.success){
                            showToast("회원가입 성공")
                            startActivity<LoginActivity>()
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