package com.project.testkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.retrofit.RetrofitManager
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val SignupActivityIntent = Intent(this, SignupActivity::class.java) //인턴트 생성
        val btn2: Button = findViewById(R.id.btn_register)        //버튼 정의

        btn2.setOnClickListener{
            startActivity(SignupActivityIntent)         //화면 전환하기
        }

        val MainActivityIntent = Intent(this, MainActivity::class.java)
        val btn3: Button = findViewById(R.id.btn_login)
        val idText : EditText = findViewById(R.id.edit_id)
        val pwText : EditText = findViewById(R.id.edit_pw)
        btn3.setOnClickListener{
            val id=idText.text.toString()
            val pw=pwText.text.toString()
            RetrofitManager.instance.Login(
                id=id,
                pw=pw
            ) { responseBody ->
                val Data = JSONObject(responseBody)
                val msg = Data.getString("message")
                if (msg == "404") {
                }else {
                    val uid = Data.getString("uid")
                    startActivity(MainActivityIntent)
                }
            }
        }
    }
}