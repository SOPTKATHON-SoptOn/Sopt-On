package com.example.sopkathon.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//싱글톤. 코드 아무데서나 접근 가능하고, 객체는 단 하나만 -> 메모리 효율
object RequestLoginToServer {
    var retrofit = Retrofit.Builder()
        .baseUrl("http://13.209.144.115:3333")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service: RequestLoginInterface = retrofit.create(RequestLoginInterface::class.java)
}