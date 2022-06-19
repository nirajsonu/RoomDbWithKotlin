package com.example.roomdbwithkotlin.firebase.storage

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.roomdbwithkotlin.R
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val REQUEST_CODE_IMAGE_PICK=0
class ImageUploadActivity : AppCompatActivity() {

    lateinit var imageView: ImageView
    lateinit var button:Button
    var curFile: Uri?=null
    val imageRef= Firebase.storage.reference
    lateinit var download_button:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_upload)

        imageView=findViewById(R.id.imageview)
        button=findViewById(R.id.send_button)
        download_button=findViewById(R.id.download_button)

        imageView.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type="image/*"
                startActivityForResult(it, REQUEST_CODE_IMAGE_PICK)
            }
        }

        button.setOnClickListener {
            uploadImageToStorage("myImage")
        }

        download_button.setOnClickListener {
            getImageToStorage("myImage")
        }




    }


    private fun getImageToStorage(filename: String)= CoroutineScope(Dispatchers.IO).launch {
        try{
            val maxDownloadSize=5L * 1024 *1024
            val bytes= imageRef.child("images/$filename").getBytes(maxDownloadSize)
          //  val bmp= BitmapFactory.decodeByteArray(bytes,0,bytes.size)
            withContext(Dispatchers.Main){
               // imageView.setImageBitmap(bmp)
            }

        }catch (e:Exception){

        }
    }

    private fun uploadImageToStorage(filename:String)= CoroutineScope(Dispatchers.IO).launch {
        try{
         curFile?.let {
             imageRef.child("images/$filename").putFile(it)
             withContext(Dispatchers.Main){
                 Toast.makeText(this@ImageUploadActivity,"Successfully uploaded image",Toast.LENGTH_LONG).show()
             }
         }
        }catch (e:Exception){
            withContext(Dispatchers.Main){
                Toast.makeText(this@ImageUploadActivity,e.message,Toast.LENGTH_LONG).show()
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode==Activity.RESULT_OK && requestCode== REQUEST_CODE_IMAGE_PICK){
            data?.data?.let{
                curFile=it
                imageView.setImageURI(it)
            }
        }
    }


}
