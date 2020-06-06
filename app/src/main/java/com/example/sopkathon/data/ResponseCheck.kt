package com.example.sopkathon.data

data class ResponseCheck(
        val status: Int,
        val success: Boolean,
        val message: String,
        val data: List<Check>
)
data class Check(
        val attendance_date: String,
        val attendance_time: String,
        val attendance_code: String,
        val attendance_check: String
)
