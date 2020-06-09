package com.example.sopkathon.Activity

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.sopkathon.*
import com.example.sopkathon.data.RequestCode
import com.example.sopkathon.network.RequestCodeToServer
import kotlinx.android.synthetic.main.activity_answer_admin.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.answer_admin_toolbar.*
import java.util.*


class AnswerAdminActivity : AppCompatActivity() {

    val requestCodeToServer = RequestCodeToServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer_admin)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        ed_answer.textChangedListener {
            buttonSelector(btn_submit)
            ed_answer.underLineSelector(code_underLine)}

        //날짜 선택
        btn_date.setOnClickListener() {
            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, day ->
                if(month<10 && day<10)
                    btn_date.setText(""  + year + "-0"+(month+1) + "-0" + day)
                else if(month<10 && day >= 10)
                    btn_date.setText(""  + year + "-0"+(month+1) + "-" + day)
                else if(month>=10 && day<10)
                    btn_date.setText(""  + year + "-" +(month+1) + "-0" + day)
                else
                    btn_date.setText(""  + year + "-" +(month+1) + "-" + day)
            }, year, month, day)
            datePicker.show()
        }

        //시간 선택
        btn_time.setOnClickListener() {
            val timePicker = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                if(minute!=0)
                    btn_time.setText("" + hour + ":" + minute)
                else
                    btn_time.setText("" + hour + ":" + minute+"0")
            }, hour, minute, false)
            timePicker.show()
        }

        //완료 버튼 클릭
        btn_submit.setOnClickListener() {
            if (btn_date.text.toString() == "날짜 생성    " || btn_time.text.toString() == "시작 시간 생성")
                showToast("시간과 날짜를 선택하세요.")
            else if (ed_answer.text.toString() == "") showToast("코드를 입력하세요.")
            else{
                requestCodeToServer.service.requestCode(
                    RequestCode(
                        seminar_date = btn_date.text.toString(),
                        seminar_time = btn_time.text.toString()+":00",
                        seminar_code = ed_answer.text.toString()
                    )
                ).customEnqueue(
                    onError = { showToast("올바르지 못한 요청입니다") },
                    onSuccess = {
                        if (it.success) {
                            showToast("코드 생성 성공")
                        } else {
                            showToast("작성하신 내용을 확인하세요.")
                        }
                    }
                )
            }
        }

        main_move.setOnClickListener() {
            startActivity<MainActivity>()
        }
    }

    private fun buttonSelector(btn : Button){
        if (ed_answer.text.isNotEmpty() && btn_date.text.toString() != "날짜 생성    " && btn_time.text.toString() != "시작 시간 생성")
            btn.setBackgroundColor(resources.getColor(R.color.main))
        else
            btn.setBackgroundColor(resources.getColor(R.color.btngray))
    }
}