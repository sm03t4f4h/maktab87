package com.example.hw10_t01_01

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CheatActivity : AppCompatActivity() {

    lateinit var textViewAnswerCheat: TextView
    lateinit var buttonShowAnswer: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)
        textViewAnswerCheat=findViewById(R.id.textViewAnswerCheat)
        buttonShowAnswer = findViewById(R.id.buttonShowAnswer)

        buttonShowAnswer.setOnClickListener{
//            textViewAnswerCheat.text=
        }

    }
}