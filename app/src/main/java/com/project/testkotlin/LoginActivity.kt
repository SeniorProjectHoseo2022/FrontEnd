package com.project.testkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

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

        btn3.setOnClickListener{
            startActivity(MainActivityIntent)
        }
    }
}