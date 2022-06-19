package com.example.roomdbwithkotlin.wifi

import android.content.Context
import android.net.wifi.WifiManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.roomdbwithkotlin.databinding.ActivityWifiBinding

class WifiActivity : AppCompatActivity() {

    lateinit var binding:ActivityWifiBinding
    lateinit var wifiManager: WifiManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWifiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        wifiManager=getApplicationContext().getSystemService(Context.WIFI_SERVICE) as  WifiManager
        wifiManager.setWifiEnabled(true)
        Toast.makeText(applicationContext,"Wifi is on now...",Toast.LENGTH_LONG).show()

        binding.wifiOff.setOnClickListener {

        }





        binding.wifiOn.setOnClickListener {
            wifiManager=getApplicationContext().getSystemService(Context.WIFI_SERVICE) as  WifiManager
            wifiManager.setWifiEnabled(true)
            Toast.makeText(applicationContext,"Wifi is on now...",Toast.LENGTH_LONG).show()
        }
    }
}