package com.example.roomdbwithkotlin.services

import android.app.IntentService
import android.content.Intent
import android.util.Log
import com.example.roomdbwithkotlin.const.Constants


//Run on Background Thread
class MyIntentService :IntentService("myIntentService"){

    init {
      //  instance= MyIntentService()
        instance=this
        isRunning=false
    }

   /* override fun stopService(name: Intent?): Boolean {
        return super.stopService(name)
    }*/


    fun stopService(){
        Log.d(Constants.SERVICE_STOP, "Service stopped")
        isRunning=false
        instance.stopService()
    }

    companion object{
        private var isRunning=false
        private lateinit var instance:MyIntentService
    }


    override fun onHandleIntent(intent: Intent?) {
        try{
            isRunning=true
            while (true){
                Thread.sleep(1000)
                Log.d(Constants.SERVICE_START, "Service started")
            }

        }catch (i:InterruptedException){
            Thread.currentThread().isInterrupted
        }

    }
}