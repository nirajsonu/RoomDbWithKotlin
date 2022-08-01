package com.example.roomdbwithkotlin.alrammanager

import android.app.Notification
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.roomdbwithkotlin.R
import com.example.roomdbwithkotlin.const.Constants

class AlarmRecevier:BroadcastReceiver() {
    override fun onReceive(context:Context?, intent: Intent?) {
        val intent=Intent(context,AlarmActvity::class.java)
        intent!!.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK




        val pendingIntent=PendingIntent.getActivity(context,0,intent,0)


        val builder= NotificationCompat.Builder(context!!,Constants.CHANNELID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(Constants.CONTENT_TITLE)
            .setContentText(Constants.CONTEXT_TEXT)
            .setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)

        val notificationManger=NotificationManagerCompat.from(context)
        notificationManger.notify(Constants.NOTIFICATION_MANAGER_KEY,builder.build())

    }
}