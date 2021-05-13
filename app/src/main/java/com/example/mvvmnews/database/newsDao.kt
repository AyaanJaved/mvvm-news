package com.example.mvvmnews.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvmnews.models.Article

@Dao
interface newsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun delete(article: Article)
}