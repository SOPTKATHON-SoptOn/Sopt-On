package com.example.sopkathon.network

import android.telecom.Call
import com.example.sopkathon.data.RequestLogin
import com.example.sopkathon.data.ResponseLogin
import com.example.sopkathon.data.ResponseRegister
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestLoginInterface {
    @Post("/user/signin")
    fun requestLogin(@Body body : RequestLogin) : Call<ResponseRegister>
}