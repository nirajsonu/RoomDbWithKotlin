package com.example.roomdbwithkotlin.broadcastreciver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.example.roomdbwithkotlin.const.Constants

class MyBroacastReciver:BroadcastReceiver() {



    override fun onReceive(context:Context?,intent:Intent?){
        val airoplanmodenable=intent?.getBooleanExtra("state",false)?:return

        val name=intent.getStringExtra("name")
        Log.d(Constants.DATA, " $name")

        if(airoplanmodenable){
            Toast.makeText(context,"Airplane mode is enable...",Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(context,"Airplane mode is disable...",Toast.LENGTH_LONG).show()
        }

    }


}