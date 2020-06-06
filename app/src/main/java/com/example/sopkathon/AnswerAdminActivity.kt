package com.example.sopkathon

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.sopkathon.data.RequestCode
import com.example.sopkathon.network.RequestToServer
import kotlinx.android.synthetic.main.activity_answer.*
import kotlinx.android.synthetic.main.activity_answer_admin.*
import kotlinx.android.synthetic.main.activity_answer_admin.tv_date
import java.util.*


class AnswerAdminActivity : AppCompatActivity() {
    val requestToServer = RequestToServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.sopkathon.R.layout.activity_answer_admin)

        Glide.with(this).load(R.drawable.adminadd_img_profileimg).into(iv_profile)


        var isDateSet = false
        var isTimeSet = false

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        //날짜 선택
        setDateLayout.setOnClickListener() {
            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, day ->
                tv_date.setText(""  + year + "." + (month+1) + "." + day)
                isDateSet = true
            }, year, month, day)
            datePicker.show()
        }

        //시간 선택
        linearLayout.setOnClickListener() {
            val timePicker = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                tv_time.setText("" + hour + ":" + minute)
                isTimeSet = true
            }, hour, minute, false)
            timePicker.show()
        }

        //완료 버튼 클릭
        btn_finish.setOnClickListener() {
            if(isDateSet && isTimeSet && ev_answer.text.isNotEmpty()) {
                requestToServer.service.requestCode(
                    RequestCode(
                        seminar_date = "2020-04-18",
                        seminar_time = "14:00:00",
                        seminar_code = "hi"
                    )
                ).customEnqueue(
                    onError = {showToast("error")},
                    onSuccess = {
                        if(it.success) {
                            showToast("코드가 생성되었습니다")
                            btn_finish.setBackgroundResource(R.drawable.round_green)
                            btn_finish.setTextColor(Color.WHITE)
                            startActivity(Intent(this, CheckAdminActivity::class.java))
                        }
                    }
                )
            }
        }
    }
}