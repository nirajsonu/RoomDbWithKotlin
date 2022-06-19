package com.example.roomdbwithkotlin.bluethooth

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.roomdbwithkotlin.databinding.ActivityBluetoothBinding


class BluetoothActivity : AppCompatActivity() {

    lateinit var bluetoothAdapter:BluetoothAdapter
    lateinit var binding:ActivityBluetoothBinding
    private var requestCodeForBluetooth:Int = 1




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_bluetooth)

        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter()
        binding= ActivityBluetoothBinding.inflate(layoutInflater)
   //     setContentView(binding.root)







        if(!bluetoothAdapter.isEnabled){
            Toast.makeText(applicationContext,"Bluetooth is not enable",Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(applicationContext,"Bluetooth is enable",Toast.LENGTH_LONG).show()
        }

        binding.btnBluethoothOn.setOnClickListener {
            if(bluetoothAdapter==null){
                Toast.makeText(applicationContext,"Bluetooth feature is not supported in your phone",Toast.LENGTH_LONG).show()
            }
            else{
                if(!bluetoothAdapter.isEnabled()){
                    bluetoothMethod()
                    getAllSerchableDevices()
                }
            }
        }


        binding.btnBluethoothOff.setOnClickListener {
            if(bluetoothAdapter.isEnabled){

                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.BLUETOOTH_CONNECT
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    bluetoothAdapter.disable()
                    return@setOnClickListener
                }

            }
        }



    }

    private fun getAllSerchableDevices() {
        var bt=bluetoothAdapter.bondedDevices
        if(bt.size>0){
            bt.forEach {
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.BLUETOOTH_CONNECT
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    val name = it.name
                    val address=it.address
                    val bluebottles=it.bluetoothClass
                    val bounded=it.bondState
                    val type=it.type
                    val uuids=it.uuids
                    Log.d("getDevice", "getAllSerchableDevices: $name,$address,$bluebottles,$bounded,$type,$uuids")
                    return
                }

            }
        }

    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun bluetoothMethod() {
        val intent=Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.BLUETOOTH_CONNECT
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            startActivityForResult(intent,requestCodeForBluetooth)
            return
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==requestCodeForBluetooth){
           if(resultCode== RESULT_OK){
               Toast.makeText(applicationContext,"Bluetooth is Enable",Toast.LENGTH_LONG).show()
           }
            else if(resultCode== RESULT_CANCELED){
                Toast.makeText(applicationContext,"Bluetooth Enabling Cancelled",Toast.LENGTH_LONG).show()
           }
       }
    }


}