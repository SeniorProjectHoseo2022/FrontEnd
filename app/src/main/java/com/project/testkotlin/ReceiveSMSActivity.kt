package com.project.testkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import android.Manifest
import android.content.pm.PackageManager

class ReceiveSMSActivity : AppCompatActivity() {

    private val requestReceiveSms = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receive_smsactivity)
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.RECEIVE_SMS)
        != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.RECEIVE_SMS),
            requestReceiveSms)
        }
    }
}