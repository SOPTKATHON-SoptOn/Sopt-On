package com.example.sopkathon.network

import com.example.sopkathon.data.RequestLogin
import com.example.sopkathon.data.ResponseLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestLoginInterface {
    @POST("/user/signin")
    fun requestLogin(@Body body : RequestLogin) : Call<ResponseLogin>
}