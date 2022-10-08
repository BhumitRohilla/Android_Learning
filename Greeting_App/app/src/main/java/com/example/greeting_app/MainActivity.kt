package com.example.greeting_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var text: EditText
    lateinit var message:TextView
    lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text=findViewById(R.id.text)
        message=findViewById(R.id.message)
        btn=findViewById(R.id.btn)
        message.text=savedInstanceState?.getString("hello") ?: "Hello"

        btn.setOnClickListener {
            message.text=text.text.toString()
            text.setText("")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("hello", message.text.toString())
    }
}