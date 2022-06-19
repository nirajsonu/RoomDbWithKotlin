package com.example.roomdbwithkotlin.lanchmode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomdbwithkotlin.R

class FirstActvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_actvity)


    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
    }


}