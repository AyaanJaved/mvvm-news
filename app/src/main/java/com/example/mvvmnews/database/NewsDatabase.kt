package com.example.mvvmnews.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [newsDao::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class NewsDatabase: RoomDatabase(){

    abstract fun getArticleDao(): newsDao

    companion object {
        var instance: NewsDatabase? = null

        fun getDatabase(context: Context): NewsDatabase? {
            if(instance == null) {
                instance = Room.databaseBuilder(context.applicationContext, NewsDatabase::class.java, "news_db.db").build()
            }
            return instance
        }
    }

}