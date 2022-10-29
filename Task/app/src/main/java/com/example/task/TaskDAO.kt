package com.example.task

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDAO {
    @Insert
    suspend fun insert(task: Task)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task:Task)

    @Query("select * from task_table where taskId=:taskID")
    fun get(taskID:Long):LiveData<Task>

    @Query("Select * from task_table order by taskId DESC")
    fun getAll():LiveData<List<Task>>
}