package com.example.roomdbwithkotlin.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView
import com.example.roomdbwithkotlin.R
import com.example.roomdbwithkotlin.timer.CountDownTimerActivity.Companion.TAG
import org.w3c.dom.Text
import java.util.*

class CountDownTimerActivity : AppCompatActivity(),Animation.AnimationListener {

    lateinit var countdown_timer_txt:TextView
    lateinit var chronometer:Chronometer
    lateinit var start_btn:Button
    lateinit var stop_chrno_btn:Button
    lateinit var animation:Animation



    companion object{
        val TAG:String="CountDownActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_down_timer)
        chronometer=findViewById(R.id.chronometer)
        start_btn=findViewById(R.id.start_btn)
        stop_chrno_btn=findViewById(R.id.stop_chrno_btn)

        countdown_timer_txt=findViewById(R.id.countdown_timer_txt)

/*
        animation=AlphaAnimation(0.0f,1.0f)
        animation.duration=50
        animation.startOffset=20
        animation.repeatMode=Animation.REVERSE
        animation.repeatCount=Animation.INFINITE
        countdown_timer_txt.startAnimation(animation)*/



       val countdowntimer=object :CountDownTimer(5000,1000){
           override fun onTick(p0: Long) {
               countdown_timer_txt.setText("" + p0 / 1000)
           }

           override fun onFinish() {
               countdown_timer_txt.setText("done!")
           }

       }



        start_btn.setOnClickListener {
            chronometer.start()
            countdowntimer.start()
        }



        stop_chrno_btn.setOnClickListener {
            chronometer.stop()
        }
      /*  val timer:Timer=Timer()
        val timerTask:t=t()
        timer.schedule(timerTask,1000,5000)*/
    }

    override fun onAnimationStart(p0: Animation?) {
        TODO("Not yet implemented")
    }

    override fun onAnimationEnd(p0: Animation?) {
        TODO("Not yet implemented")
    }

    override fun onAnimationRepeat(p0: Animation?) {
        TODO("Not yet implemented")
    }


}

class t:TimerTask(){
    var x=0
    override fun run() {
        Log.d(TAG, "run: $x++")
    }

}