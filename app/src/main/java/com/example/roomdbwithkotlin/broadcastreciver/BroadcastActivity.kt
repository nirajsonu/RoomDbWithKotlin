package com.example.roomdbwithkotlin.broadcastreciver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomdbwithkotlin.R
import com.example.roomdbwithkotlin.const.Constants
import com.example.roomdbwithkotlin.databinding.ActivityBroadcastBinding

class BroadcastActivity : AppCompatActivity() {
    lateinit var myBroacastReciver: MyBroacastReciver
    lateinit var binding:ActivityBroadcastBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBroadcastBinding.inflate(layoutInflater)

        setContentView(binding.root)


     /*   binding.sendData.setOnClickListener {
             val intent=Intent(applicationContext,MyBroacastReciver::class.java)
            intent.putExtra(Constants.DATA,"Neeraj")


        }*/



        myBroacastReciver= MyBroacastReciver()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(myBroacastReciver,it)
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(myBroacastReciver)
    }
}