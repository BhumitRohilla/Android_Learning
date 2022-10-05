package com.example.stopwatch

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    var offset:Long=0
    var status=false
    lateinit var timer:Chronometer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timer=findViewById<Chronometer>(R.id.stopwatch)
        val start=findViewById<Button>(R.id.start)
        val pause=findViewById<Button>(R.id.pause)
        val reset=findViewById<Button>(R.id.reset)
        if(savedInstanceState!=null){
            offset=savedInstanceState.getLong("offset_key")
            status=savedInstanceState.getBoolean("status")
            if(status){
                timer.base=savedInstanceState.getLong("base_key")
                timer.start()
            }
        }
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

    override fun onSaveInstanceState(saveState:Bundle){
        super.onSaveInstanceState(saveState)
        saveState.putLong("offset_key",offset)
        saveState.putLong("base_key",timer.base)
        saveState.putBoolean("status",status)
    }
}