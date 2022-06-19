package com.example.roomdbwithkotlin.firebase.crashlytics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.roomdbwithkotlin.R
import com.google.firebase.crashlytics.FirebaseCrashlytics

class CrstlayticsActivity : AppCompatActivity() {

    lateinit var crashButton:Button
    lateinit var firebaseCrashlytics: FirebaseCrashlytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crstlaytics)

        crashButton=findViewById(R.id.crash_btn)






        crashButton.setOnClickListener {
            throw RuntimeException("Test Crash")
        }
    }
}