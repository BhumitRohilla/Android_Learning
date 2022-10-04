package com.example.stopwatch

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val timer=findViewById<Chronometer>(R.id.stopwatch)
        val start=findViewById<Button>(R.id.start)
        val pause=findViewById<Button>(R.id.pause)
        val reset=findViewById<Button>(R.id.reset)
        var offset:Long=0
        var status=false
        start.setOnClickListener {
            if(!status){
                timer.base=SystemClock.elapsedRealtime()-offset
                timer.start()
                status=true
                start.visibility=View.GONE
                pause.visibility=View.VISIBLE
            }
        }
        pause.setOnClickListener {
            if(status){
                timer.stop()
                offset=SystemClock.elapsedRealtime()-timer.base
                status=false
                pause.visibility=View.GONE
                start.visibility=View.VISIBLE
            }
        }
        reset.setOnClickListener {
            timer.base=SystemClock.elapsedRealtime()
        }
    }
}