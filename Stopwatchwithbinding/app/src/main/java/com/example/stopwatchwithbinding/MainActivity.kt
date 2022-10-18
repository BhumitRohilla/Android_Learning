package com.example.stopwatchwithbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.PersistableBundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import android.widget.Toast
import com.example.stopwatchwithbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    var status:Boolean=false
    var offset:Long=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        if(savedInstanceState!=null){
            offset=savedInstanceState.getLong("offset")
            status=savedInstanceState.getBoolean("status")
            binding.timer.base=SystemClock.elapsedRealtime()-offset
            binding.timer.start()
        }
        val reset:Button=findViewById(R.id.reset)
        binding.start.setOnClickListener {
            if(!status){
                binding.timer.base=SystemClock.elapsedRealtime()-offset
                binding.timer.start()
                offset=0
                status=true
            }else{
                Toast.makeText(this,"Timer is already running dumb-ass",Toast.LENGTH_SHORT).show()
            }
        }
        binding.pause.setOnClickListener {
            if(status){
                binding.timer.stop();
                status=false
                offset=SystemClock.elapsedRealtime()-binding.timer.base
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("status",status)
        offset=SystemClock.elapsedRealtime()-binding.timer.base
        outState.putLong("offset",offset)
    }
}