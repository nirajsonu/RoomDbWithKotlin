package com.example.roomdbwithkotlin.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private const val url="https://quotable.io/"

    fun getInstance():Retrofit{
        return Retrofit.Builder().
        baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}