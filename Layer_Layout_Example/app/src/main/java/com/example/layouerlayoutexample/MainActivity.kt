package com.example.layouerlayoutexample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button=findViewById<Button>(R.id.btnSend)
        val toText=findViewById<EditText>(R.id.to)
        val message=findViewById<EditText>(R.id.message)
        button.setOnClickListener {
            toText.setText("")
            message.setText("")
            Toast.makeText(this,"Sending",Toast.LENGTH_LONG).show()
        }
    }

}