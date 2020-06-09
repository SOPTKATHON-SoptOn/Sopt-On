package com.example.sopkathon.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.sopkathon.*
import com.example.sopkathon.data.LoginRegister.RequestLogin
import com.example.sopkathon.data.LoginRegister.RequestLoginAdmin
import com.example.sopkathon.network.LoginRegister.RequestLoginAdminToServer
import com.example.sopkathon.network.LoginRegister.RequestLoginToServer
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(){

    val requestLoginToServer = RequestLoginToServer
    val requestLoginAdminToServer = RequestLoginAdminToServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        ed_id.textChangedListener {
            buttonSelector(btn_login)
            ed_id.underLineSelector(id_underLine)}

        ed_pw.textChangedListener {
            buttonSelector(btn_login)
            ed_pw.underLineSelector(pw_underLine)}

        btn_login.setOnClickListener{
            if(ed_id.text.isNullOrBlank() || ed_pw.text.isNullOrBlank()){
                showToast("아이디와 비밀번호를 확인하세요.")
            }else {
                if(admin_check.isChecked) {
                    requestLoginToServer.service.requestLogin(
                        RequestLogin(
                            user_id = ed_id.text.toString(),
                            password = ed_pw.text.toString()
                        )
                    ).customEnqueue(
                        onError = { showToast("올바르지 못한 요청입니다") },
                        onSuccess = {
                            if (it.success) {
                                val intent = Intent(this, MainActivity::class.java)
                                intent.putExtra("check", admin_check.isChecked)
                                startActivity(intent)
                            } else {
                                showToast("아이디와 비밀번호를 확인하세요.")
                            }
                        }
                    )
                }
                else {
                    requestLoginAdminToServer.service.requestLoginAdmin(
                        RequestLoginAdmin(
                            leader_id = ed_id.text.toString(),
                            password = ed_pw.text.toString()
                        )
                    ).customEnqueue(
                        onError = { showToast("올바르지 못한 요청입니다") },
                        onSuccess = {
                            if (it.success) {
                                val intent = Intent(this, MainActivity::class.java)
                                intent.putExtra("check", admin_check.isChecked)
                                startActivity(intent)
                            } else {
                                showToast("아이디와 비밀번호를 확인하세요.")
                            }
                        }
                    )
                }
            }
        }

        tv_register.setOnClickListener {
            startActivity<RegisterActivity>()
        }
    }

    private fun buttonSelector(btn : Button){
        if (ed_id.text.isNotEmpty() && ed_pw.text.isNotEmpty())
            btn.setBackgroundColor(resources.getColor(R.color.main))
        else
            btn.setBackgroundColor(resources.getColor(R.color.btngray))
    }
}