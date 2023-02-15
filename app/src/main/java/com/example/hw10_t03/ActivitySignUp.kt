package com.example.hw10_t03

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivitySignUp : AppCompatActivity() {
    lateinit var editTextUserName: EditText
    lateinit var editTextNumberPassword: EditText
    lateinit var buttonSignUp: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        editTextUserName = findViewById(R.id.editTextUserNameInSignUp)
        editTextNumberPassword = findViewById(R.id.editTextNumberPasswordInSignUp)
        buttonSignUp = findViewById(R.id.buttonSignUpInSignUp)


        buttonSignUp.setOnClickListener {

            val openMainActivity = Intent()
            openMainActivity.putExtra("KEY_USERNAME" , editTextUserName.text)
            openMainActivity.putExtra("KEY_PASSWORD" , editTextNumberPassword.text)
            setResult(RESULT_OK, openMainActivity)
            finish()

//            if (editTextUserName.text.isEmpty()) {
//                Toast.makeText(this, "Please enter UserName", Toast.LENGTH_LONG).show()
//            } else if (editTextNumberPassword.text.isEmpty()) {
//                Toast.makeText(this, "Please enter Password", Toast.LENGTH_LONG).show()
//            } else {
//
//            }
        }
    }
}