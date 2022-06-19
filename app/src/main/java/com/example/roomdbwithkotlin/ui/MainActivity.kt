package com.example.roomdbwithkotlin.ui

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import androidx.room.Room
import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.roomdbwithkotlin.R
import com.example.roomdbwithkotlin.database.MyRoomDB
import com.example.roomdbwithkotlin.databinding.ActivityMainBinding
import com.example.roomdbwithkotlin.model.Student
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    private var LOG:String= MainActivity::javaClass.name


    private lateinit var database:MyRoomDB
    private lateinit var binding:ActivityMainBinding
    private lateinit var name:String
    private lateinit var roll:String
    private lateinit var city:String
    private var is_present:Int=0
    private var query:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        val binding:ActivityMainBinding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        roomDatabaseBuilder()
        setRawQuery()
        getOneStudentData()
        isTableExistOrNot()
        deleteMultipleRecords()
        setListners(binding)

    }

    private fun setListners(binding: ActivityMainBinding) {
        binding.apply {
            insertData.setOnClickListener(View.OnClickListener {
                name=studentName.text.toString()
                roll=rollNumber.text.toString()
                city=cityEdt.text.toString()

                radioBtn.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{ radioGroup: RadioGroup?, i: Int ->
                    when(i){
                        R.id.present_radio ->is_present=0
                        R.id.absent_radio ->is_present=1
                        else->is_present=0
                    }
                })
                insertDataToRoomDB()

            })
        }
    }


    private fun deleteMultipleRecords() {
        val list= listOf<Int>(1,2,3)
        GlobalScope.launch {
            database.studentDao().deleteMultipleRecords(list)
        }
    }

    private fun isTableExistOrNot() {
        GlobalScope.launch {
            val boolean=database.studentDao().value()
            if(boolean){
                Log.d(LOG, "Table Exists")
            }else{
                Log.d(LOG, "Table is not Exists ")
            }

        }
    }

    private fun setRawQuery() {
        query="SELECT * FROM student"
        val supportedSql=SimpleSQLiteQuery(query)
        val rawQuery=database.studentDao().getRawQuery(supportedSql)

        rawQuery.observe(this){
            Log.d(LOG, "$it")
        }
    }

    private fun getOneStudentData() {
        database.studentDao().getFilterData(1).observe(this) {
            Log.d("Roomdb", ":$it")
            for(data in it){
                var city=data.city
                val id = data.id
                val createdDate = data.createdDate
                val present = data.isPresent
                val name1 = data.name

            }

        }
    }




    private fun roomDatabaseBuilder() {
        database= Room.databaseBuilder(applicationContext,
            MyRoomDB::class.java,
            "StudentDB").addMigrations(MyRoomDB.migrationFrom1_2).build()
    }

    private fun insertDataToRoomDB() {
         GlobalScope.launch {
           val value:Long= database.studentDao().insertData(Student(0, name, roll, Date(), is_present, city))
             Log.d(TAG, "insertDataToRoomDB:$value")

                 Handler(Looper.getMainLooper()).post {
                     if(value>0){
                         Toast.makeText(applicationContext,"Data inserted...",Toast.LENGTH_LONG).show()
                 }
                     else{
                         Toast.makeText(applicationContext,"Data not inserted..",Toast.LENGTH_LONG).show()
                     }
             }

        }

    }


}