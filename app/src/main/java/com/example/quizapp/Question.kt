package com.example.quizapp

data class Question(
    val id:Int,
    val question:String,
    val option_One:String,
    val option_Two:String,
    val option_Three:String,
    val option_Four:String,
    val image:Int,
    val correctOption:Int
)
