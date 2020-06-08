package com.example.sopkathon.Activity

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sopkathon.R
import com.example.sopkathon.RecyclerAdapter
import com.example.sopkathon.startActivity
import kotlinx.android.synthetic.main.activity_check_admin.*
import kotlinx.android.synthetic.main.activity_check_admin.setTimeLayout
import kotlinx.android.synthetic.main.activity_check_admin.setDateLayout
import kotlinx.android.synthetic.main.activity_check_admin.tv_date
import kotlinx.android.synthetic.main.activity_check_admin.tv_time
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.check_admin_toolbar.*
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

        main_move.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("check", check1.isChecked)
            startActivity(intent)
        }
        //시간 선택
        setTimeLayout.setOnClickListener() {
            val timePicker = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                if(minute != 0)
                    tv_time.setText("" + hour + ":" + minute)
                else
                    tv_time.setText("" + hour + ":" + minute+"0")
            }, hour, minute, false)
            timePicker.show()
        }
    }
}