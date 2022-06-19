package com.example.roomdbwithkotlin.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.example.roomdbwithkotlin.const.Constants


//Run on UI Thread
class MyService: Service() {
    override fun onBind(p0: Intent?): IBinder? =null


    init{
        Log.d(Constants.SERVICE_START, "Service started")
    }




    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val dataString=intent?.getStringExtra(Constants.EXTRA)
        dataString?.also {
            Log.d(Constants.SERVICE_START, "$dataString")
        }
        return START_STICKY
        // return START_REDELIVER_INTENT  //if service is killed by the system it will redeliver the last intent
//        return START_STICKY     if service is killed by the system it will created if possible
//        return START_NOT_STICKY  if service is killed by the system it will not be created
    }
}