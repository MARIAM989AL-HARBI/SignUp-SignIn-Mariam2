package com.example.signupandsignin_mariam2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUp : AppCompatActivity() {

        private lateinit var nameEditText : EditText
        private lateinit var mobileEditText : EditText
        private lateinit var locationEditText : EditText
        private lateinit var passwordEditText : EditText

        private lateinit var signupButton : Button

        private lateinit var dbhr : DBH

        private var phone = ""
        private var name = ""
        private var location = ""
        private var password = ""

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_sign_up)

            dbhr = DBH(applicationContext)

            nameEditText = findViewById(R.id.nameEditText)
            mobileEditText = findViewById(R.id.mobileEditText)
            locationEditText = findViewById(R.id.locationEditText)
            passwordEditText = findViewById(R.id.passwordEditText)

            signupButton = findViewById(R.id.signupButton)
            signupButton.setOnClickListener {
                name = nameEditText.text.toString()
                phone = mobileEditText.text.toString()
                location = locationEditText.text.toString()
                password = passwordEditText.text.toString()

                var status = dbhr.savedata(phone, name, location, password)
                Toast.makeText(applicationContext,"wow :)Data Saved Successfully " + status, Toast.LENGTH_SHORT).show()

                val intent = Intent(this@SignUp, Details::class.java).apply {
                    putExtra("Phone", phone)
                }
                startActivity(intent)
            }
        }
    }