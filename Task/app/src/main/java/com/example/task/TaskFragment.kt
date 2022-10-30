package com.example.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.task.databinding.FragmentTaskBinding


class TaskFragment : Fragment(){
    private var _binding:FragmentTaskBinding?=null
    val binding get()=_binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentTaskBinding.inflate(inflater,container,false)
        val application= requireNotNull(this.activity).application
        val dao=TaskDatabase.getInstance(application).taskDAO
        val viewModelFactory= TaskViewModelFactory(dao)
        val viewMode= ViewModelProvider(this,viewModelFactory).get(TasksViewModel::class.java)
        binding.viewModel=viewMode
        binding.lifecycleOwner=viewLifecycleOwner

        val adapter=TaskItemAdapter()
        binding.tasksList.adapter=adapter

        viewMode.tasks.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data=it
            }
        })
        return binding.root
    }
}