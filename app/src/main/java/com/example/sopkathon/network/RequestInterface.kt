package com.example.sopkathon.network

import com.example.sopkathon.data.RequestCode
import com.example.sopkathon.data.RequestRegister
import com.example.sopkathon.data.ResponseCode
import com.example.sopkathon.data.ResponseRegister
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestInterface{
    @POST("/seminar/setcode")
    fun requestCode(@Body body : RequestCode) : Call<ResponseCode>
}