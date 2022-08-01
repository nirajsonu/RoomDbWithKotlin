package com.example.roomdbwithkotlin.database

import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.roomdbwithkotlin.convertors.MyConverters
import com.example.roomdbwithkotlin.dao.StudentDao
import com.example.roomdbwithkotlin.model.Student


@Database(entities = [Student::class], version = 2)
@TypeConverters(MyConverters::class)
abstract class MyRoomDB :RoomDatabase() {

    companion object {
        val migrationFrom1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE student " + " ADD COLUMN f_name INTEGER default 0 NOT NULL")
            }

        }

        val migrationFrom2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE student ADD COLUMN age TEXT NOT NULL DEFAULT '0'")


            }
        }


    }
    abstract fun studentDao(): StudentDao
}