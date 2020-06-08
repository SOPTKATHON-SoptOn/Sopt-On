package com.example.sopkathon.network.LoginRegister
import com.example.sopkathon.data.LoginRegister.RequestRegister
import com.example.sopkathon.data.LoginRegister.ResponseRegister

import retrofit2.http.Body
import retrofit2.http.POST

interface RequestRegisterInterface{
    @POST("/user/signup")
    fun requestRegister(@Body body : RequestRegister) : retrofit2.Call<ResponseRegister>
}