package com.example.sopkathon.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.sopkathon.*
import com.example.sopkathon.data.LoginRegister.RequestRegister
import com.example.sopkathon.network.LoginRegister.RequestRegisterToServer
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    val requestRegisterToServer =
        RequestRegisterToServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        ed_name.textChangedListener {
            buttonSelector(btn_complete)
            underLineSelector(name_underLine, ed_name)}
        ed_id.textChangedListener {
            buttonSelector(btn_complete)
            underLineSelector(id_underLine, ed_id)}
        ed_pw.textChangedListener {
            buttonSelector(btn_complete)
            underLineSelector(pw_underLine, ed_pw)}
        ed_birth.textChangedListener {
            buttonSelector(btn_complete)
            underLineSelector(birth_underLine, ed_birth)}

        btn_complete.setOnClickListener() {
            if (ed_id.text.isNullOrBlank() || ed_pw.text.isNullOrBlank() || ed_name.text.isNullOrBlank() || ed_birth.text.isNullOrBlank()) {
                showToast("가입 정보를 확인하세요")
            }   else {
                requestRegisterToServer.service.requestRegister(
                    RequestRegister(
                        user_name = ed_name.text.toString(),
                        user_birth = ed_birth.text.toString(),
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

    private fun underLineSelector(underLine : View, ed : EditText) {
        if (ed.text.isNotEmpty())
            underLine.setBackgroundColor(resources.getColor(R.color.main))
        else
            underLine.setBackgroundColor(resources.getColor(R.color.underline))
    }

    private fun buttonSelector(btn : Button){
        if (ed_name.text.isNotEmpty() && ed_id.text.isNotEmpty() && ed_pw.text.isNotEmpty() && ed_birth.text.isNotEmpty())
            btn_complete.setBackgroundColor(resources.getColor(R.color.main))
        else
            btn_complete.setBackgroundColor(resources.getColor(R.color.btngray))
    }
}