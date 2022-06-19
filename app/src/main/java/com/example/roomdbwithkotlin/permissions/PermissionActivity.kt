package com.example.roomdbwithkotlin.permissions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.roomdbwithkotlin.R
import com.example.roomdbwithkotlin.databinding.ActivityPermissionBinding

class PermissionActivity : AppCompatActivity() {

    lateinit var binding:ActivityPermissionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPermissionBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.getPermissionBtn.setOnClickListener {

        }

        var x="neeraj@123"
      var c=  x.count {
            val digit = it.isDigit()
            digit
        }
        Toast.makeText(applicationContext,"$c",Toast.LENGTH_LONG).show()

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}