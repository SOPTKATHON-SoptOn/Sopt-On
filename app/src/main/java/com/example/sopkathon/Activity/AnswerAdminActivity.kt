package com.example.sopkathon.Activity

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.sopkathon.R
import com.example.sopkathon.textChangedListener
import kotlinx.android.synthetic.main.activity_answer_admin.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.answer_admin_toolbar.*
import java.util.*


class AnswerAdminActivity : AppCompatActivity() {

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
            underLineSelector(code_underLine, ed_answer)}

        //날짜 선택
        btn_date.setOnClickListener() {
            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, day ->
                btn_date.setText(""  + year + "." + (month+1) + "." + day)
            }, year, month, day)
            datePicker.show()
        }

        //시간 선택
        btn_time.setOnClickListener() {
            val timePicker = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                btn_time.setText("" + hour + ":" + minute)
            }, hour, minute, false)
            timePicker.show()
        }

        //완료 버튼 클릭
        btn_submit.setOnClickListener() {
            startActivity(Intent(this, CheckAdminActivity::class.java))
        }

        main_move.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("check", check1.isChecked)
            startActivity(intent)
        }
    }

    private fun underLineSelector(underLine : View, ed : EditText) {
        if (ed.text.isNotEmpty())
            underLine.setBackgroundColor(resources.getColor(R.color.main))
        else
            underLine.setBackgroundColor(resources.getColor(R.color.underline))
    }

    private fun buttonSelector(btn : Button){
        if (ed_answer.text.isNotEmpty())
            btn.setBackgroundColor(resources.getColor(R.color.main))
        else
            btn.setBackgroundColor(resources.getColor(R.color.btngray))
    }
}