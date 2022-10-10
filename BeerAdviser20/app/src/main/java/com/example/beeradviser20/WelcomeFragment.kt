package com.example.beeradviser20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import androidx.navigation.findNavController


class WelcomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_welcome, container, false)
        val btn=view.findViewById<Button>(R.id.btn1)

        btn.setOnClickListener {
            val text=view.findViewById<Spinner>(R.id.spinner).selectedView.toString()
            val action=WelcomeFragmentDirections.actionWelcomeFragmentToChosenFragment(text)
            view.findNavController().navigate(action)
        }
        return view
    }
}