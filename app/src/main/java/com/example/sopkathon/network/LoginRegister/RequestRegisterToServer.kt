package com.example.sopkathon.network.LoginRegister

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//싱글톤. 코드 아무데서나 접근 가능하고, 객체는 단 하나만 -> 메모리 효율
object RequestRegisterToServer {
    var retrofit = Retrofit.Builder()
        .baseUrl("http://52.79.151.21:3000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service: RequestRegisterInterface = retrofit.create(
        RequestRegisterInterface::class.java)
}