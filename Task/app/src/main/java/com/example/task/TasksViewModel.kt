package com.example.task


import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TasksViewModel(val dao:TaskDAO):ViewModel() {
    var newTaskName=""
    val tasks=dao.getAll()

    fun addTask(){
        viewModelScope.launch {
            val task=Task()
            task.taskName=newTaskName
            dao.insert(task)
        }
    }
}