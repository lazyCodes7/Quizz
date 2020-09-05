package com.example.quiz_app

import java.util.ArrayList

object Constants{
    const val USER_NAME :String = "user name"
    const val TOTAL_QUESTION : String = "Total questions"
    const val CORRECT_ANS : String = "correct_ans"
    fun getQuestion():ArrayList<Quizquestions>{
        val questionList = ArrayList<Quizquestions>()
        val ques1 = Quizquestions(1,
            "Which country flag is this?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Brazil",
            "Mexico",
            "USA",
            1)
        questionList.add(ques1)

        val ques2 = Quizquestions(2,
            "Which country flag is this?",
            R.drawable.ic_flag_of_australia,
            "USA",
            "Brazil",
            "New South Wales",
            "Australia",
            4)
        questionList.add(ques2)
        val ques3 = Quizquestions(3,
            "Which country flag is this?",
            R.drawable.ic_flag_of_belgium,
            "Ghana",
            "Belgium",
            "Germany",
            "Mexico",
            2)
        questionList.add(ques3)

        val ques4 = Quizquestions(4,
            "Which country flag is this?",
            R.drawable.ic_flag_of_new_zealand,
            "New Zealand",
            "Australia",
            "USA",
            "India",
            1)
        questionList.add(ques4)

        val ques5 = Quizquestions(5,
            "Which country flag is this?",
            R.drawable.ic_flag_of_brazil,
            "Brazil",
            "Bangladesh",
            "Japan",
            "Cuba",
            1)
        questionList.add(ques5)

        val ques6 = Quizquestions(6,
            "Which country flag is this?",
            R.drawable.ic_flag_of_india,
            "Italy",
            "India",
            "Japan",
            "Cuba",
            2)
        questionList.add(ques6)

        val ques7 = Quizquestions(7,
            "Which country flag is this?",
            R.drawable.ic_flag_of_denmark,
            "Italy",
            "England",
            "Denmark",
            "Sweden",
            3)
        questionList.add(ques7)

        val ques8 = Quizquestions(8,
            "Which country flag is this?",
            R.drawable.ic_flag_of_fiji,
            "Fiji",
            "England",
            "New Zealand",
            "Russia",
            1)
        questionList.add(ques8)

        val ques9 = Quizquestions(9,
            "Which country flag is this?",
            R.drawable.ic_flag_of_germany,
            "Belgium",
            "Germany",
            "Russia",
            "Croatia",
            2)
        questionList.add(ques9)

        val ques10 = Quizquestions(10,
            "Which country flag is this?",
            R.drawable.ic_flag_of_kuwait,
            "Canada",
            "Kuwait",
            "Oman",
            "UAE",
            2)
        questionList.add(ques10)

        return questionList
    }

}