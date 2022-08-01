package com.example.roomdbwithkotlin.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="quote")
data class MyRoomDBModel (

    @PrimaryKey(autoGenerate = true)
    val quoteId:Int,
    val _id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int
        )