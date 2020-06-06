package com.example.sopkathon

import android.telecom.Call
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.security.auth.callback.Callback

fun <ResponseType> Call<ResponseType>.customEnqueue(
    onFail : () -> Unit = { Log.d("network", "통신에 실패했습니다.")},
    onSuccess : (ResponseType) -> Unit,
    onError : () -> Unit
){
    this.enqueue(object : Callback<ResponseType> {
        override fun onFailure(call: Call<ResponseType>, t: Throwable) {
            onFail()
        }

        override fun onResponse(call: Call<ResponseType>, response: Response<ResponseType>) {
            response.body()?.let {
                onSuccess(it)
            } ?: onError()
        }
    })
}
