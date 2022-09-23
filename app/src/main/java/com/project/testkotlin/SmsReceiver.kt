package com.project.testkotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.SmsMessage
import android.util.TypedValue
import android.widget.Toast
import com.example.myapplication.retrofit.RetrofitManager
import com.google.android.material.snackbar.Snackbar
import org.json.JSONObject

class SmsReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {

        val extras = intent.extras

        if(extras != null){
            val sms = extras.get("pdus") as Array<Any>
            var messageText = ""
            for (i in sms.indices){
                val format = extras.getString("format")

                var smsMessage = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    SmsMessage.createFromPdu(sms[i] as ByteArray,format)
                }else{
                    SmsMessage.createFromPdu(sms[i] as ByteArray)
                }
                val phoneNumber = smsMessage.originatingAddress
                messageText += smsMessage.messageBody.toString()
            }
            val text = messageText
            val uid = "1"
            val pid = "1"

            RetrofitManager.instance.AI_Request(
                text =text,
                uid =uid,
                pid =pid
            ) { responseBody ->
                val Data = JSONObject(responseBody)
                val message_Confirm = Data.getString("message_confirm").toInt()
                val url = Data.getString("url")
                val url_confirm = Data.getString("url_confirm").toInt()
                val confirm_text = arrayOf("안전", "위험")

                val response = "\n메세지 : " + text +
                        "\n메세지 탐지 결과 : " + confirm_text[message_Confirm]+
                        "\n탐지 URL : " +  url +
                        "\nURL 탐지 결과 : " + confirm_text[url_confirm]
                Toast.makeText(
                    context,
                    response,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}