package com.example.roomdbwithkotlin.speechregonizer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.roomdbwithkotlin.R
import java.util.*
import kotlin.collections.ArrayList

class SpeechRegonizer : AppCompatActivity() {
    val intentRequestCode:Int=100

    lateinit var textToSpeech: TextToSpeech
    lateinit var text_to_speech:Button
    lateinit var speech:EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speech_regonizer)
        val btn = findViewById<Button>(R.id.speck)
        text_to_speech=findViewById(R.id.text_to_speech)
        speech=findViewById(R.id.speech);



        var sb:StringBuffer=StringBuffer()
        sb.codePointAt(1)


        textToSpeech= TextToSpeech(applicationContext, TextToSpeech.OnInitListener {
            if(it!=TextToSpeech.ERROR){
                textToSpeech.setLanguage(Locale.US)
            }
        })
        text_to_speech.setOnClickListener {
            textToSpeech.speak(speech.text.toString(),TextToSpeech.QUEUE_FLUSH,null)
        }
        btn.setOnClickListener {
            showRecogniser()
        }

    }

    private fun showRecogniser() {
        val intent= Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,Locale.getDefault())
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speak Open Camera")
        startActivityForResult(intent,intentRequestCode)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==100 && resultCode== RESULT_OK && data!=null){
            val stringArrayExtra = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            if(stringArrayExtra?.get(0).toString().equals("open camera"))
            {
                Toast.makeText(applicationContext,"Neeraj Reginior..",Toast.LENGTH_LONG).show()
            }
        }
        else{
            Toast.makeText(applicationContext,"not going",Toast.LENGTH_LONG).show()
        }
    }
}