package com.example.sopkathon.network.LoginRegister

import com.example.sopkathon.data.LoginRegister.RequestLogin
import com.example.sopkathon.data.LoginRegister.ResponseLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestLoginInterface {
    @POST("/user/signin")
    fun requestLogin(@Body body : RequestLogin) : Call<ResponseLogin>
}