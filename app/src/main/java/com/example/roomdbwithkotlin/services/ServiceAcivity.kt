package com.example.roomdbwithkotlin.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomdbwithkotlin.R
import com.example.roomdbwithkotlin.const.Constants
import com.example.roomdbwithkotlin.databinding.ActivityServiceAcivityBinding

class ServiceAcivity : AppCompatActivity() {

    lateinit var binding:ActivityServiceAcivityBinding
    lateinit var service:MyIntentService
    lateinit var value:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityServiceAcivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        service= MyIntentService()


        binding.startServiceBtn.setOnClickListener {
       /*     val intent=Intent(applicationContext,MyIntentService::class.java)
            startService(intent)*/

            Intent(this,MyIntentService::class.java).also {
                startService(it)
            }

        }

        binding.stopServiceBtn.setOnClickListener {
            service.stopService()
        }

        binding.btnSendData.setOnClickListener {
            value=binding.edtSendData.text.toString()

        }

    }
}