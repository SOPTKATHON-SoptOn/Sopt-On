package com.example.sopkathon.data.LoginRegister

data class ResponseLoginAdmin(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : SomeDataAdmin?
)

data class SomeDataAdmin(
    val leader_id : String
)