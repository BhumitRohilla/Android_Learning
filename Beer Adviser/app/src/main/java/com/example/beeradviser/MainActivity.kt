package com.example.beeradviser


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button=findViewById<Button>(R.id.beer_sug)
        val textview=findViewById<TextView>(R.id.beer_text)
        val spinnerValue=findViewById<Spinner>(R.id.beer_color)
        button.setOnClickListener{
            val str:String= spinnerValue.selectedItem.toString()
            val list:List<String> =getBeers(str)
            val text: String=list.reduce { string, item -> string + '\n' + item }
            textview.text=text
        }
    }

    fun getBeers(beer_color: String):List<String>{
        return when(beer_color){
            "Light"-> listOf("Jail Pale Ale", "Lager Lite")
            "Amber"-> listOf("Jack Amber", "Red Moose")
            "Brown"-> listOf("Brown Beer Beer","Bock Brownie")
            else-> listOf("Gout Stout", "Dark Daniel")
        }
    }

}