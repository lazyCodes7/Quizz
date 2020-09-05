package com.example.quiz_app

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quiz_app.Constants.getQuestion
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var mquestionsList : ArrayList<Quizquestions>
    var mSelectedOptionPosition : Int? = 0
    var mCurrentPosition : Int? = 1
    private var mUsername : String? = null
    private var mCorrectAnswers:Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mUsername=intent.getStringExtra(Constants.USER_NAME)
        setContentView(R.layout.activity_quiz_question)
        setQuestions()
        textView_optionOne.setOnClickListener(this)
        textView_optionTwo.setOnClickListener(this)
        textView_optionThree.setOnClickListener(this)
        textView_optionFour.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }

    private fun setQuestions(){
        mquestionsList = getQuestion()
        val question : Quizquestions? = mquestionsList[mCurrentPosition!! -1]
        if(mCurrentPosition==mquestionsList.size){
            btn_submit.text="FINISH"
        }
        else{
            btn_submit.text="SUBMIT"
        }
        defaultOptionsView()
        progress_bar_quiz.progress= mCurrentPosition as Int
        progress_textView.text="$mCurrentPosition"+"/"+ progress_bar_quiz.max
        question_textView.text=question?.question
        question?.image?.let { flag_imageView.setImageResource(it) }
        textView_optionOne.text=question?.optionOne
        textView_optionTwo.text=question?.optionTwo
        textView_optionThree.text=question?.optionThree
        textView_optionFour.text=question?.optionFour

    }
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,textView_optionOne)
        options.add(1,textView_optionTwo)
        options.add(2,textView_optionThree)
        options.add(3,textView_optionFour)
        for (opt in options){
            opt.setTextColor(Color.parseColor("#7A8089"))
            opt.typeface= Typeface.DEFAULT
            opt.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.textView_optionOne ->{
                selectedOptionsView(textView_optionOne,1)
            }
            R.id.textView_optionTwo ->{
                selectedOptionsView(textView_optionTwo,2)
            }
            R.id.textView_optionThree ->{
                selectedOptionsView(textView_optionThree,3)
            }
            R.id.textView_optionFour ->{
                selectedOptionsView(textView_optionFour,4)
            }
            R.id.btn_submit ->{
                if(mSelectedOptionPosition==0){
                    mCurrentPosition = mCurrentPosition!! +1
                    when {
                            mCurrentPosition!!<=mquestionsList.size ->{
                                setQuestions()
                            }else ->{
                                val intent = Intent(this,ResultActivity::class.java)
                                intent.putExtra(Constants.USER_NAME,mUsername)
                                intent.putExtra(Constants.CORRECT_ANS,mCorrectAnswers)
                                intent.putExtra(Constants.TOTAL_QUESTION,mquestionsList.size)
                                startActivity(intent)
                            }
                    }
                }else{
                    val questions = mquestionsList[mCurrentPosition!!-1]
                    if(questions.correctOption!=mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition!!,R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAnswers++
                    }
                    answerView(questions.correctOption!!,R.drawable.correct_option_border_bg)
                    if(mCurrentPosition==mquestionsList.size){
                        btn_submit.text="Finish quiz"

                    }
                    else{
                        btn_submit.text="Go to next question"
                    }
                    mSelectedOptionPosition=0

                }

            }
        }

    }
    private fun answerView(answer: Int,drawableView: Int){
        when(answer){
            1 -> textView_optionOne.background = ContextCompat.getDrawable(this,drawableView)
            2 -> textView_optionTwo.background = ContextCompat.getDrawable(this,drawableView)
            3 -> textView_optionThree.background = ContextCompat.getDrawable(this,drawableView)
            4 -> textView_optionFour.background = ContextCompat.getDrawable(this,drawableView)
        }

    }
    private fun selectedOptionsView(tv: TextView,selectedOptionNo : Int){
        
        defaultOptionsView()
        mSelectedOptionPosition=selectedOptionNo
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.when_clicked_border_bg)
    }
}