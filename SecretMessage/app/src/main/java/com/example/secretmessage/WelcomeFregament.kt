package com.example.secretmessage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class WelcomeFregament : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_welcome_fregament, container, false)
        val btn1=view.findViewById<Button>(R.id.btn1)

        btn1.setOnClickListener {
            val navC=view.findNavController()
            navC.navigate(R.id.action_welcomeFregament_to_messageFragment)
        }
        return view
    }
}