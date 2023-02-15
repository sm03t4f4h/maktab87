package com.example.hw10_t03


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var editTextUserName: EditText
    lateinit var editTextNumberPassword: EditText
    lateinit var buttonLogin: Button
    lateinit var buttonSignUp: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextUserName = findViewById(R.id.editTextUserNameInSignUp)
        editTextNumberPassword = findViewById(R.id.editTextNumberPasswordInLogIn)
        buttonLogin = findViewById(R.id.buttonLoginInLogin)
        buttonSignUp = findViewById(R.id.buttonSignUpInLogin)

        val snackbar =
            findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.snackbar)

        val userName = intent?.getStringExtra("UserName")
        editTextUserName.setText(userName)
        val password = intent?.getStringExtra("Password")
        editTextNumberPassword.setText(password)


        val registerForSignUp = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        )
        { result ->
            if (result.resultCode == RESULT_OK) {

                val userName = result.data?.getStringExtra("KEY_USERNAME").toString()
                editTextUserName.setText(userName)

                val numberPassword = result.data?.getStringExtra("KEY_USERNAME").toString()
                editTextNumberPassword.setText(numberPassword)
            }
        }

        buttonSignUp.setOnClickListener {
            val myIntent = Intent(this , ActivitySignUp::class.java)
            registerForSignUp.launch(myIntent)
        }

        buttonLogin.setOnClickListener {
            if (editTextUserName.text.isEmpty() || editTextNumberPassword.text.isEmpty()) {
                Toast.makeText(this, "Please enter UserName And Password", Toast.LENGTH_LONG).show()
            }
            if (editTextUserName.text.toString() == userName ||
                editTextNumberPassword.text.toString() == password
            ) {
                Snackbar.make(snackbar, "UserName and Password is current", Snackbar.LENGTH_LONG)
                    .setAction("ok") {

                    }.show()
            }
        }
    }
}
