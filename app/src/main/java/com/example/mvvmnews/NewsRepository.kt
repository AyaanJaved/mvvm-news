package com.example.mvvmnews

import com.example.mvvmnews.database.NewsDatabase
import com.example.mvvmnews.networking.RetrofitSingleton

class NewsRepository (val db: NewsDatabase){
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) = RetrofitSingleton.retrofit.getBreakingNews(countryCode, pageNumber, "1f973fe5e75e4c97b39851c7607b91f8")

    suspend fun searchNews(searchQuery: String, pageNumber: Int) {
        RetrofitSingleton.retrofit.searchForNews(searchQuery, pageNumber)
    }
}
