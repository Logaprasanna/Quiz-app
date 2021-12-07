package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private var userName:String? = null
    private var correctAnswers:Int? = null
    private var totalQuestions:Int? = null

    private var resultName:TextView? = null
    private var scoreCard:TextView? = null
    private var btn_finish: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        resultName = findViewById(R.id.resultName)
        scoreCard = findViewById(R.id.scoreCard)
        btn_finish = findViewById(R.id.btn_result_finish)

        userName = intent.getStringExtra(Constants.USERNAME)
        correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)

        resultName?.text = "Congratulations $userName!!"
        scoreCard?.text = "Your score is $correctAnswers out of $totalQuestions"

        btn_finish?.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}