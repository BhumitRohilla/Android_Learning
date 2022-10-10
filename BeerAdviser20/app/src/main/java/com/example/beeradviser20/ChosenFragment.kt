package com.example.beeradviser20

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.w3c.dom.Text

class ChosenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_chosen, container, false)
        val textview=view.findViewById<TextView>(R.id.text_chosen)
        var text=ChosenFragmentArgs.fromBundle(requireArguments()).chosen
        val list:List<String> =getBeers(text)
        text=list.reduce{ string, item -> string + '\n' + item }
        textview.text=text
        return view
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