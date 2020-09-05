@file:Suppress("DEPRECATION")

package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val username = intent.getStringExtra(Constants.USER_NAME)
        tv_name.text=username.toString()
        val score = intent?.getIntExtra(Constants.CORRECT_ANS,0)
        val questions = intent.getIntExtra(Constants.TOTAL_QUESTION,0)
        tv_score.text = "Your score is $score out of $questions"
        btn_finish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}