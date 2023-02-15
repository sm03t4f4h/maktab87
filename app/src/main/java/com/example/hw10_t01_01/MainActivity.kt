package com.example.hw10_t01_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    //    private lateinit var textViewGeoQuizTop: TextView
    private lateinit var textViewQuestions: TextView
    private lateinit var buttonTRUE: Button
    private lateinit var buttonFALSE: Button
    private lateinit var buttonCHEAT: Button
    private lateinit var buttonPREV: Button
    private lateinit var buttonNEXT: Button

    val game = Game()
    val player = Player("Hooshang")
    var numberOfQuestion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewQuestions = findViewById(R.id.textViewQuestions)
        buttonTRUE = findViewById(R.id.buttonTRUE)
        buttonFALSE = findViewById(R.id.buttonFALSE)
        buttonCHEAT = findViewById(R.id.buttonCHEAT)
        buttonPREV = findViewById(R.id.buttonPREV)
        buttonNEXT = findViewById(R.id.buttonNEXT)



        textViewQuestions.text = game.questions[numberOfQuestion]

        buttonNEXT.setOnClickListener {
            choose()
            if (numberOfQuestion < game.questions.size - 1) {
                numberOfQuestion += 1
            } else {
                buttonNEXT.isClickable = false
            }
            textViewQuestions.text = game.questions[numberOfQuestion]
        }

        buttonPREV.setOnClickListener {
            choose()
            if (numberOfQuestion > 0) {
                numberOfQuestion -= 1
            } else {
                buttonPREV.isClickable = false
            }
            textViewQuestions.text = game.questions[numberOfQuestion]
        }

        buttonTRUE.setOnClickListener {
            player.playerAnswers.add(true)
            selected()
        }

        buttonFALSE.setOnClickListener {
            player.playerAnswers.add(false)
            selected()
        }

        buttonCHEAT.setOnClickListener {

            val myIntent = Intent()

        }
//            val activityResult =
//                registerForActivityResult(
//                    ActivityResultContracts
//                        .StartActivityForResult()
//                ) { result ->
//                    if (result.resultCode== RESULT_OK)
//                }
//        }

//        override fun onSaveInstanceState(outState: Bundle) {
//            super.onSaveInstanceState(outState)
//            outState.putString("QUESTION", game.questions[numberOfQuestion])
//        }
//
//        override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//            super.onRestoreInstanceState(savedInstanceState)
//
//        }

    }

    private fun selected() {
        buttonTRUE.isClickable = false
        buttonFALSE.isClickable = false
        if (player.playerAnswers[numberOfQuestion] == game.answers[numberOfQuestion]) {
            Toast.makeText(this, "Correct", Toast.LENGTH_LONG).show()
            player.positiveScore += 1
        } else if (player.playerAnswers[numberOfQuestion] != game.answers[numberOfQuestion]) {
            Toast.makeText(this, "Incorrect", Toast.LENGTH_LONG).show()
            player.negativeScore += 1
        }
    }

    private fun choose() {
        buttonTRUE.isClickable = true
        buttonFALSE.isClickable = true
    }
}


class Player(inputName: String) {
    var name = inputName
    var playerAnswers = mutableListOf<Boolean>()
    var playerScore = 0
    var positiveScore = 0
    var negativeScore = 0

    fun finalScore() {
        if (negativeScore == 0) {
            playerScore = positiveScore
        }
        playerScore = positiveScore - (negativeScore / 3)
    }
}

class Game() {

    val questions = mutableListOf<String>(
        "2+2=4",                                                 //true   0
        "The largest country in the world is Russia",            //true   1
        "The capital city of Australia is Canberra.",            //true   2
        "Rivers hold 20% of the world’s water.",                 //False  3
        "More people live in Venice than Bari, Italy.",          //False  4
        "Kabul is the capital of Afghanistan.",                  //true   5
        "Vatican City is the smallest country in the world.",    //true   6
        "Los Angeles is the capital of California.",             //False  7
        "The Taj Mahal is in India.",                            //true   8
        "Portuguese is the official language of Brazil."         //true   9
    )
    val answers = mutableListOf<Boolean>(
        true,   //0
        true,   //1
        true,   //2
        false,  //3
        false,  //4
        true,   //5
        true,   //6
        false,  //7
        true,   //8
        true,   //9
    )
    val cheatAnswer = mutableListOf<Boolean>()

}
