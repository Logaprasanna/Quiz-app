package com.example.quizapp

object Constants {

    const val USERNAME = "user_name"
    const val TOTAL_QUESTIONS = "total_questions"
    const val CORRECT_ANSWERS = "correct_answers"


    fun getQuestion(): ArrayList<Question> {
        var questionsList = ArrayList<Question>()

        var ques1 = Question(
            1,"What breed does this dog belong to?",
            "Shiba Inu",
            "Cane Corso",
            "Labrador",
            "Pug",
            R.drawable.cane_corso,
            2
            )
        questionsList.add(ques1)

        var ques2 = Question(
            2,"What breed does this dog belong to?",
            "Siberian Husky",
            "Pomeranian",
            "Dachshund",
            "Boxer",
            R.drawable.boxer,
            4
        )
        questionsList.add(ques2)

        var ques3 = Question(
            3,"What breed does this dog belong to?",
            "Rottweiler",
            "Labrador",
            "German Shepherd",
            "Chow Chow",
            R.drawable.german_sheperd,
            3
        )
        questionsList.add(ques3)

        var ques4 = Question(
            4,"What breed does this dog belong to?",
            "Border Collie",
            "Doberman",
            "Great Dane",
            "German Shepherd",
            R.drawable.dobermann,
            2
        )
        questionsList.add(ques4)

        var ques5 = Question(
            5,"What breed does this dog belong to?",
            "Chihuahua",
            "Boxer",
            "Great Dane",
            "St.Bernard",
            R.drawable.great_dane,
            3
        )
        questionsList.add(ques5)

        var ques6 = Question(
            6,"What breed does this dog belong to?",
            "American Bully",
            "Dalmatian",
            "Pitbull",
            "American Bulldog",
            R.drawable.american_bulldog,
            4
        )
        questionsList.add(ques6)

        var ques7 = Question(
            7,"What breed does this dog belong to?",
            "Kangal",
            "Boston Terrier",
            "Siberian Husky",
            "Greyhound",
            R.drawable.kangal,
            1
        )
        questionsList.add(ques7)

        var ques8 = Question(
            8,"What breed does this dog belong to?",
            "Pomeranian",
            "Cane Corso",
            "Bulldog",
            "Labrador",
            R.drawable.labrador,
            4
        )
        questionsList.add(ques8)

        var ques9 = Question(
            9,"What breed does this dog belong to?",
            "Pitbull",
            "Belgian Malinois",
            "American Bully",
            "French Bulldog",
            R.drawable.pitbull,
            1
        )
        questionsList.add(ques9)

        var ques10 = Question(
            10,"What breed does this dog belong to?",
            "Golden Retriever",
            "Doberman",
            "Rottweiler",
            "Bulldog",
            R.drawable.rottweiler,
            3
        )
        questionsList.add(ques10)

        return questionsList
    }
}