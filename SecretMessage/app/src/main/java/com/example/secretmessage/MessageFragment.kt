package com.example.secretmessage

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController

class MessageFragment : Fragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_message, container, false)
        val btn=view.findViewById<Button>(R.id.btn2)

        btn.setOnClickListener {
            val message:String=view.findViewById<TextView>(R.id.message_text).text.toString()
            val action=MessageFragmentDirections.actionMessageFragmentToEncryptFragment(message)
            val controller=view.findNavController()
            controller.navigate(action)
        }
        return view
    }
}