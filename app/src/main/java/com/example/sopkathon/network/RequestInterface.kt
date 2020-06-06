package com.example.sopkathon.network

import com.example.sopkathon.data.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestInterface{
    @POST("/seminar/setcode")
    fun requestCode(@Body body : RequestCode) : Call<ResponseCode>
    @POST("/attendance/checkin")
    fun requestCheck(@Body body : RequestCheck) :Call<ResponseCheck>
}