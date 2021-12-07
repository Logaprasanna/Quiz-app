package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var btnStart:Button? = null
    private var tv_EditText: EditText?  = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart = findViewById(R.id.btn_start)
        tv_EditText = findViewById(R.id.tv_EditText)

        btnStart?.setOnClickListener{
            if(tv_EditText?.text!!.isNotEmpty()){
                //Move on to next activity
                var intent = Intent(this,
                QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USERNAME, tv_EditText!!.text.toString())
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this,
                "Enter your name to proceed!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}