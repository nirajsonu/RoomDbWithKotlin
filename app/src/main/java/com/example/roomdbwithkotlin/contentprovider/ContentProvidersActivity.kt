package com.example.roomdbwithkotlin.contentprovider

import android.content.pm.PackageManager
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CallLog
import android.telecom.Call
import android.util.Log
import android.widget.SimpleCursorAdapter
import androidx.core.app.ActivityCompat
import com.example.roomdbwithkotlin.R
import java.util.jar.Manifest

class ContentProvidersActivity : AppCompatActivity() {

    var columns=listOf<String>(CallLog.Calls._ID,
    CallLog.Calls.NUMBER,
    CallLog.Calls.TYPE,
    CallLog.Calls.DURATION).toTypedArray()


    lateinit var cursor: Cursor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_providers)
        checkCallLogPermissions()
    }

    private fun checkCallLogPermissions() {
        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.READ_CALL_LOG)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                Array(1){android.Manifest.permission.READ_CALL_LOG},101
            )
        }
        else{
            displayLog()
        }
    }

    private fun displayLog() {
        cursor= contentResolver.query(CallLog.Calls.CONTENT_URI,columns,null,null,"${CallLog.Calls.LAST_MODIFIED} DESC")!!

        if(cursor!=null && cursor.moveToFirst()){

           while (cursor.moveToNext()){
               val index=cursor.getColumnIndexOrThrow("number")
               val number=cursor.getString(index)


               val index1=cursor.getColumnIndexOrThrow("duration")
               val duration=cursor.getString(index1)
               Log.d("number", "displayLog: $duration")
           }

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)


        if(requestCode==101 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            displayLog()
        }
    }
}