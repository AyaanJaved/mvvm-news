package com.example.mvvmnews.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitSingleton {
    companion object {
        private val retrofit by lazy{
            Retrofit.Builder().baseUrl("https://newsapi.org").addConverterFactory(GsonConverterFactory.create()).build().create(
                NewsApi::class.java)
        }
    }
}