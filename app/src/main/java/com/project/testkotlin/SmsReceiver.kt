package com.project.testkotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.SmsMessage
import com.example.myapplication.retrofit.RetrofitManager
import org.json.JSONArray
import org.json.JSONObject

class SmsReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val extras = intent.extras
        val pf = context.getSharedPreferences("test",Context.MODE_PRIVATE)
        val editor = pf.edit()
        var phoneNumber = ""
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
                phoneNumber = smsMessage.originatingAddress.toString()
                messageText += smsMessage.messageBody.toString()
            }
            val text = messageText
            val uid = "1"
            val pid = "4"

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
                val obj :JSONArray
                if (pf.contains(phoneNumber))
                    obj = JSONArray(pf.getString(phoneNumber,""))
                else
                    obj = JSONArray()
                val temp = JSONObject()
                temp.put("message", text)
                temp.put("pid", pid)
                temp.put("message_confirm", confirm_text[message_Confirm])
                temp.put("url", url)
                temp.put("url_confirm", confirm_text[url_confirm])
                obj.put(temp)
                editor.putString(phoneNumber, obj.toString())

                val pns : JSONObject
                if (pf.contains("pns"))
                    pns = JSONObject(pf.getString("pns",""))
                else
                    pns = JSONObject()
                pns.put(phoneNumber, text)
                editor.putString("pns", pns.toString())
                editor.commit()
            }
        }
    }
}