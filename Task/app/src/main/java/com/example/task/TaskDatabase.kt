package com.example.task

import android.content.Context
import android.view.ViewDebug.IntToString
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase(){
    abstract val taskDAO:TaskDAO

    companion object{
        @Volatile
        private var INSTANCE:TaskDatabase?=null
        fun getInstance(context: Context):TaskDatabase{
            var instance= INSTANCE
            if(instance==null){
                instance= Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    "tasks_database"
                ).build()
                INSTANCE=instance
            }
            return instance
        }
    }
}