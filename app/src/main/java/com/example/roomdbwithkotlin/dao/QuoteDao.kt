package com.example.roomdbwithkotlin.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdbwithkotlin.model.MyRoomDBModel
import com.example.roomdbwithkotlin.model.Result


@Dao
interface QuoteDao {
    @Insert
    suspend fun addQuotes(quotes: List<Result>)


    @Query("SELECT * FROM quote")
    suspend fun getQuotes():List<Result>
}