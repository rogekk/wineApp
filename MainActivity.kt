package com.example.winemakerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        (findViewById(R.id.button) as Button).setOnClickListener {
            val intent = Intent(this, Signin::class.java)
            startActivity(intent)
        }
        (findViewById<Button>(R.id.button2)).setOnClickListener {
            val intent = Intent(this,SignIn::class.java)
            startActivity(intent)
        }
    }
}