package com.example.sopkathon

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_answer_admin.*
import kotlinx.android.synthetic.main.activity_check_admin.*
import kotlinx.android.synthetic.main.activity_check_admin.linearLayout
import kotlinx.android.synthetic.main.activity_check_admin.setDateLayout
import kotlinx.android.synthetic.main.activity_check_admin.tv_date
import kotlinx.android.synthetic.main.activity_check_admin.tv_time
import java.util.*

class CheckAdminActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_admin)

        recyclerView.adapter = RecyclerAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)

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
            }, year, month, day)
            datePicker.show()
        }

        //시간 선택
        linearLayout.setOnClickListener() {
            val timePicker = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                tv_time.setText("" + hour + ":" + minute)
            }, hour, minute, false)
            timePicker.show()
        }
    }

}