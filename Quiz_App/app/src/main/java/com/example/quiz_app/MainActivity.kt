package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_start.setOnClickListener {
            if(textView_name.text.toString().isEmpty()){
                Toast.makeText(this,"Please enter name",Toast.LENGTH_LONG)
            }
            else{
                val intent = Intent(this,QuizQuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME,textView_name.text.toString())
                startActivity(intent)

                finish()
            }
        }
    }
}