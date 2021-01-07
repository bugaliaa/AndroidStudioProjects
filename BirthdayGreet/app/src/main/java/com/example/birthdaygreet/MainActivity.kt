package com.example.birthdaygreet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val createBirthdayButton: Button = findViewById(R.id.createBirthdayButton)
        createBirthdayButton.setOnClickListener {
            val name = findViewById<EditText>(R.id.inputName)
            val intent = Intent(this, BirthdayGreetActivity::class.java)
            intent.putExtra(BirthdayGreetActivity.NAME_EXTRA, name.text.toString())
            startActivity(intent)
        }
    }
}