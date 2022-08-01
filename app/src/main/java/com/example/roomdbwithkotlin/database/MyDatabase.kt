package com.example.roomdbwithkotlin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdbwithkotlin.dao.QuoteDao
import com.example.roomdbwithkotlin.model.Result


@Database(entities = [Result::class], version = 1)
abstract  class MyDatabase:RoomDatabase() {

    abstract fun quoteDao():QuoteDao

    companion object{
        @Volatile
        private var INSTANCE:MyDatabase?=null

        fun getDatabase(context:Context):MyDatabase{
            if(INSTANCE==null){
                INSTANCE=Room.databaseBuilder(context,
                MyDatabase::class.java,
                "quoteDB").build()
            }
            return INSTANCE!!
        }
    }


}