package com.example.biggernumberdemp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import java.util.Random

class MainActivity : AppCompatActivity() {
    lateinit var left:Button
    lateinit var right:Button
    lateinit var main:ConstraintLayout
    lateinit var toast:Toast
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toast=Toast.makeText(this,"",Toast.LENGTH_SHORT)
        left=findViewById<Button>(R.id.left)
        right=findViewById<Button>(R.id.right)
        main=findViewById<ConstraintLayout>(R.id.mainActivity)
        randomNumber(left,right)
        left.setOnClickListener {
            check(true)
        }
        right.setOnClickListener {
            check(false)
        }


    }
    fun randomNumber(left:Button,right:Button){
        val rand:Random=Random()
        left.text=rand.nextInt(10).toString()
        right.text=rand.nextInt(10).toString()
        return
    }
    fun check(isLeft:Boolean){
        if(isLeft){
            if(left.text.toString().toInt()>right.text.toString().toInt()){
                main.setBackgroundColor(Color.GREEN)
                toast.cancel()
                toast.setText("Correct")
                toast.show()
            }else{
                main.setBackgroundColor(Color.RED)
                toast.cancel()
                if(left.text.toString().toInt()==right.text.toString().toInt()){
                    toast.setText(":->")
                }else
                    toast.setText("In-Correct")
                toast.show()
            }
        }else{
            if(right.text.toString().toInt()>left.text.toString().toInt()){
                main.setBackgroundColor(Color.GREEN)
                toast.cancel()
                toast.setText("Correct")
                toast.show()
            }else{
                main.setBackgroundColor(Color.RED)
                toast.cancel()
                if(left.text.toString().toInt()==right.text.toString().toInt()){
                    toast.setText(":->")
                }else
                    toast.setText("In-Correct")
                toast.show()
            }
        }
        randomNumber(left,right)
    }


}