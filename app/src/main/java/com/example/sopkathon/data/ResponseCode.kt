package com.example.sopkathon.data

data class ResponseCode(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: SeminarData?
)

data class SeminarData(
    val seminar_date: String,
    val seminar_time: String,
    val seminar_Code: String
)