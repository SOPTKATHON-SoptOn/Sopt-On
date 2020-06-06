package com.example.sopkathon.data

data class ResponseLogin(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : SomeData?
)

data class SomeData(
    val user_idx : Int
)