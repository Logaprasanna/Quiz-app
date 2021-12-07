package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var correctAnswer:Int = 0
    private var totalQuestions:Int? = null
    private var userName:String? = null

    private var questionsList = ArrayList<Question>()
    private var currentPosition:Int = 1
    private var selectedOptionPosition:Int = 0

    private var tvQuestion:TextView? = null
    private var imageView:ImageView? = null
    private var progressBar:ProgressBar? = null
    private var qCount:TextView? = null

    private var optionOne:TextView? = null
    private var optionTwo:TextView? = null
    private var optionThree:TextView? = null
    private var optionFour:TextView? = null

    private var btn_Submit: Button? = null



    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        tvQuestion = findViewById(R.id.tv_question)
        imageView = findViewById(R.id.dogImage)
        progressBar = findViewById(R.id.progress_bar)
        qCount = findViewById(R.id.Q_count)

        optionOne = findViewById(R.id.option_one)
        optionTwo = findViewById(R.id.option_two)
        optionThree = findViewById(R.id.option_three)
        optionFour = findViewById(R.id.option_four)
        btn_Submit = findViewById(R.id.btn_submit)

        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)
        btn_Submit?.setOnClickListener(this)

        userName = intent.getStringExtra(Constants.USERNAME)

        questionsList = Constants.getQuestion()
        setQuestion()

    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        defaultOption()
        var question = questionsList[currentPosition-1]

        tvQuestion?.text = question.question
        imageView?.setImageResource(question.image)
        progressBar?.progress = currentPosition
        qCount?.text = "$currentPosition / ${questionsList.size}"

        optionOne?.text = question.option_One
        optionTwo?.text = question.option_Two
        optionThree?.text = question.option_Three
        optionFour?.text = question.option_Four

        if(currentPosition<=questionsList.size){
            btn_Submit?.text = "Submit"
        }else
            btn_Submit?.text = "Finish"
    }

    //selected option v default option function
    private fun defaultOption(){
        var options = ArrayList<TextView>()

        optionOne?.let {
            options.add(it) }
        optionTwo?.let {
            options.add(it) }
        optionThree?.let {
            options.add(it) }
        optionFour?.let {
            options.add(it) }

        for(option in options){
            option.setTextColor(Color.parseColor("#6c757d"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,
            R.drawable.default_border)
        }
    }

    //Now the selected option
    private fun selectedOption(tv:TextView, selecOption:Int){
        defaultOption()
        selectedOptionPosition = selecOption
        tv.setTextColor(Color.parseColor("#495057"))
        tv.typeface = Typeface.DEFAULT_BOLD
        tv.background = ContextCompat.getDrawable(this,
        R.drawable.selected_option_border)
    }

    // The answer view
    private fun answerView(answer:Int, drawable:Int){
        when(answer){
            1-> {
                optionOne?.background = ContextCompat.getDrawable(
                    this, drawable
                )
            }
            2-> {
                optionTwo?.background = ContextCompat.getDrawable(
                this, drawable
                )
            }
            3-> {
                optionThree?.background = ContextCompat.getDrawable(
                    this, drawable
                )
            }
            4-> {
                optionFour?.background = ContextCompat.getDrawable(
                    this, drawable
                )
            }
        }

    }

    //on click functionality
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.option_one ->{
                optionOne?.let { selectedOption(it, 1) }
            }
            R.id.option_two ->{
                optionTwo?.let { selectedOption(it, 2) }
            }
            R.id.option_three ->{
                optionThree?.let { selectedOption(it, 3) }
            }
            R.id.option_four ->{
                optionFour?.let { selectedOption(it, 4) }
            }
            R.id.btn_submit ->  {

                if(selectedOptionPosition == 0){
                    currentPosition++
                    when{
                        currentPosition<=questionsList.size  -> setQuestion()
                        else -> {
                            totalQuestions = questionsList.size
                            var intent = Intent(this,
                            ResultActivity::class.java)
                            intent.putExtra(Constants.USERNAME, userName)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, totalQuestions)
                            intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswer)

                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else{
                    var question = questionsList[currentPosition-1]
                    if(selectedOptionPosition != question.correctOption){
                        answerView(selectedOptionPosition, R.drawable.wrong_option_border)
                    } else{
                        correctAnswer++
                    }
                    answerView(question.correctOption, R.drawable.correct_option_border)

                    if (currentPosition==questionsList.size){
                        btn_Submit?.text = "Finish"
                    }else{
                        btn_Submit?.text = "NEXT QUESTION"
                    }

                    selectedOptionPosition = 0
                }
            }
        }
    }




}