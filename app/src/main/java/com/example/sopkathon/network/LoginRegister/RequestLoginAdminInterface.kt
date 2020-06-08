package com.example.sopkathon.network.LoginRegister

import com.example.sopkathon.data.LoginRegister.RequestLoginAdmin
import com.example.sopkathon.data.LoginRegister.ResponseLoginAdmin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestLoginAdminInterface {
    @POST("/leader/signin")
    fun requestLoginAdmin(@Body body : RequestLoginAdmin) : Call<ResponseLoginAdmin>
}