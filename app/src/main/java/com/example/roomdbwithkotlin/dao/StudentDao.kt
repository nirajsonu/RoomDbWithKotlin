package com.example.roomdbwithkotlin.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.roomdbwithkotlin.model.MyRoomDBModel
import com.example.roomdbwithkotlin.model.QuoteModel
import com.example.roomdbwithkotlin.model.Result
import com.example.roomdbwithkotlin.model.Student

@Dao
interface StudentDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(student: Student):Long

    @Delete
    suspend fun deleteStudent(student: Student)

    @Query("SELECT * FROM student")
    fun getAllStudent():LiveData<List<Student>>

    @Query("SELECT * FROM student where id=:id")
    fun getFilterData(id:Long):LiveData<List<Student>>


    @RawQuery(observedEntities = [Student::class])
    fun getRawQuery(query: SupportSQLiteQuery): LiveData<List<Student>>


    @Query("SELECT EXISTS(SELECT * FROM student)")
    suspend fun value():Boolean

    @Query("delete from student where id in(:idList)")
    suspend fun deleteMultipleRecords(idList:List<Int>)

    @Update
    suspend fun updateOneRecords(student: Student):Int
}

