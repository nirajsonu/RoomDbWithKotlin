package com.example.roomdbwithkotlin.alrammanager

import android.app.*
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.roomdbwithkotlin.R
import com.example.roomdbwithkotlin.databinding.ActivityAlarmActvityBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

class AlarmActvity : AppCompatActivity() {

    lateinit var bindig:ActivityAlarmActvityBinding
    lateinit var pickerDialog: MaterialTimePicker
    lateinit var alramManager:AlarmManager
    lateinit var pendingIntent:PendingIntent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        bindig= ActivityAlarmActvityBinding.inflate(layoutInflater)

        //createNotificationChannel()

        bindig.selectTimeBtn.setOnClickListener {
            showDialog()

        }

        bindig.setAlarmBtn.setOnClickListener {
            setAlarm()
        }

        bindig.cancelBtn.setOnClickListener {

        }





    //    setContentView(bindig.root)
    }

    private fun setAlarm() {
        alramManager=getSystemService(ALARM_SERVICE) as AlarmManager
        val intent=Intent(this,AlarmRecevier::class.java)
        pendingIntent=PendingIntent.getBroadcast(this,0,intent,0)
       /* alramManager.setRepeating(
            AlarmManager.RTC_WAKEUP,

        )*/
    }

    private fun showDialog() {
        pickerDialog=MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Select Alarm Time")
            .build()

        pickerDialog.show(supportFragmentManager,"Neeraj")

        pickerDialog.addOnPositiveButtonClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if(pickerDialog.hour >12){
                    bindig.timerTxt.text=String.format("%02d",pickerDialog.hour -12)+" :"+String.format(
                        "%02d",
                        pickerDialog.minute
                    )+"PM"
                }
                else{
                    String.format("%02d",pickerDialog.hour-12)+" :"+String.format(
                        "%02d",
                        pickerDialog.minute
                    )+"PM"
                }
            }
        })

    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val name:CharSequence="Neeraj"
            val description="Channel For Alarm Manager"
            val importance=NotificationManager.IMPORTANCE_HIGH
            val channel=NotificationChannel("",name,importance)

            channel.description=description
            val notificationManager=getSystemService(
                NotificationManager::class.java
            )

            notificationManager.createNotificationChannel(channel)
        }
    }
}