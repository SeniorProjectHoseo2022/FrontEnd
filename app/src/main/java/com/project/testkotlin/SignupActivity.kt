package com.project.testkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val prevbtnIntent = Intent(this, LoginActivity::class.java) //인턴트 생성
        val btn2: Button = findViewById(R.id.btn_back)        //버튼 정의

        btn2.setOnClickListener{
            startActivity(prevbtnIntent)         //화면 전환하기
        }

        val signup_btn = findViewById<Button>(R.id.btn_signup)
        signup_btn.setOnClickListener{
            val editText = findViewById<EditText>(R.id.signID)
            val editText2 = findViewById<EditText>(R.id.signName)

            var text1 = editText.text.toString()
            var text2 = editText2.text.toString()
            val LoginActivityIntent = Intent(this, LoginActivity::class.java)

            var dialog = AlertDialog.Builder(
                this@SignupActivity)

            dialog.setTitle("알람")
            dialog.setMessage("안녕하세요" + text2 + "님 ! \n"  + "입력하신 " + text1 + "로 회원가입에 성공하였습니다!")
            dialog.show()
        }
    }
}