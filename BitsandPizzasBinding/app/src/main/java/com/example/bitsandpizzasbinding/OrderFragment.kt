package com.example.bitsandpizzasbinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.bitsandpizzasbinding.databinding.FragmentOrderBinding
import com.google.android.material.appbar.MaterialToolbar

class OrderFragment : Fragment() {
    private var _binding:FragmentOrderBinding?=null
    private val binding get()=_binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentOrderBinding.inflate(inflater,container,false)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        return binding.root
    }
}