package com.example.sopkathon.network
import com.example.sopkathon.data.RequestRegister
import com.example.sopkathon.data.ResponseRegister

import retrofit2.http.Body
import retrofit2.http.POST

interface RequestRegisterInterface{
    @POST("/user/signup")
    fun requestRegister(@Body body : RequestRegister) : retrofit2.Call<ResponseRegister>
}