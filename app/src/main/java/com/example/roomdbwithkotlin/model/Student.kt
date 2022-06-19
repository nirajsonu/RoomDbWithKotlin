package com.example.roomdbwithkotlin.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName="student")
data class Student(
                   @PrimaryKey(autoGenerate = true)
                   val id:Long,
                   val name:String,
                   val roll_nol:String,
                   val createdDate:Date,
                   val isPresent:Int,
                   val city:String
                   )

